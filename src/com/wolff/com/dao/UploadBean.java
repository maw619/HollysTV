package com.wolff.com.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.sun.media.sound.AlawCodec;
import com.wolff.com.model.TV;

@ManagedBean
public class UploadBean extends Conexion {

	

	private String folder = "C:\\Users\\Marco\\eclipse-workspace-2020\\HollysTV_JSF\\WebContent\\resources\\images\\";
	
	private Part file;
	
	private String path;
	

	
	
	public UploadBean() {
		
	}
	
	
	public String loadImage(int id) {
		this.getConn();
		TV t = null;
		String sql = "SELECT * FROM tvlist WHERE id=?";
		try {
			t = new TV();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				t.setId(rs.getInt("id"));
				t.setImage(rs.getString("image"));
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				Map<String, Object> sessionMap = externalContext.getSessionMap();
				sessionMap.put("imageid", t);
				System.out.println(t.getId());
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "editimage";
	}
	
	public String updateImage(TV tv) {
		String sql = "UPDATE tvlist SET image = ? WHERE id = ?";
		String imgPath = "";
		this.getConn();
		InputStream input;
		try {
			 input = file.getInputStream();
				 Files.copy(input, new File(folder, file.getSubmittedFileName()).toPath(),StandardCopyOption.REPLACE_EXISTING);
					
			        System.out.println("Submitted: " + file.getSize());
			        path = folder+file.getSubmittedFileName();
			        System.out.println("this is the real path: "+path);
			        String alternate = "resources/images/"+file.getSubmittedFileName();
			        System.out.println(alternate);
			        System.out.println(file.getName());
			        PreparedStatement ps = this.conn.prepareStatement(sql);
			        ps.setString(1, alternate);
			        ps.setInt(2, tv.getId());
			        ps.executeUpdate();
			    
		
		}catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return "index.xhtml";
	}
	
	
	
	public String editChannel(TV tv) {
		
		this.getConn();
			String sql = "UPDATE tvlist SET channel = ?, site = ?, url = ?, video = ?, genre = ? WHERE id=?";
	
			try {
				
				        PreparedStatement ps = this.conn.prepareStatement(sql);
				        
				        ps.setString(1, tv.getChannel());
				        ps.setString(2, tv.getSite());
				        ps.setString(3, tv.getUrl());
				        ps.setString(4, tv.getVideo());
				        ps.setString(5, tv.getGenre());
				        ps.setInt(6, tv.getId());
				        ps.executeUpdate();
		      
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return "index";
		}

	
	public String saveChannel(TV tv) {
		this.getConn();
		String sql = "INSERT into tvlist (channel,site,url,video,genre,image) VALUES (?,?,?,?,?,?)";
		InputStream input = null;
		try {
			    input = file.getInputStream();
				Files.copy(input, new File(folder, file.getSubmittedFileName()).toPath(),StandardCopyOption.REPLACE_EXISTING);
		        System.out.println("Submitted: " + file.getSize());
		        path = folder+file.getSubmittedFileName();
		        System.out.println("this is the real path: "+path);
		        String alternate = "resources/images/"+file.getSubmittedFileName();
		        System.out.println(alternate);
		        PreparedStatement ps = this.conn.prepareStatement(sql);
		        ps.setString(1, tv.getChannel());
		        ps.setString(2, tv.getSite());
		        ps.setString(3, tv.getUrl());
		        ps.setString(4, tv.getVideo());
		        ps.setString(5, tv.getGenre());
		        ps.setString(6, alternate);
		        ps.executeUpdate();
		}catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	public String loadChannel(int id) {
		try {
			TVController tv = new TVController();
			TV t = tv.getChannel(id);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("tvList", t);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "edit";
	}


	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String delete(int id) {
		this.getConn();
		String sql = "delete from tvlist where id=?";
		try {
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
	}


}
