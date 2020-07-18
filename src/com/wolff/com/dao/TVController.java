package com.wolff.com.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.wolff.com.model.TV;


@SessionScoped
@ViewScoped
@ManagedBean
public class TVController extends Conexion{
	
	public TVController() {
		Conexion c = new Conexion();
		c.getConn();
		listAll();
	}
	
	public String vid(int id) throws IOException {
		String sql = "SELECT * FROM tvlist WHERE id =?";
		String url = "";
		String vid = "";
		List<TV>listar = null;
		try {
			listar = new ArrayList<>();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TV t = new TV();
				t.setUrl(rs.getString("url"));
				t.setUrl(rs.getString("video"));
				url = rs.getString("url");
				vid = rs.getString("video");
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				Map<String, Object> sessionMap = externalContext.getSessionMap();
				sessionMap.put("vid", vid);
				listar.add(t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(url);
		System.out.println(vid);
		return "view/main.xhtml";
	}

	@PostConstruct
	public List<TV>listAll(){
//		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		List<TV>listar = null;
		String sql = "SELECT * FROM tvlist ORDER by channel";
		this.getConn();
		try {
			listar = new ArrayList<>();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TV t = new TV(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				
				listar.add(t);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listar;
	}
	
	
	@PostConstruct
	public List<TV>news(){
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		List<TV>listar = null;
		String sql = "SELECT * FROM tvlist WHERE genre = 'news'";
		this.getConn();
		try {
			listar = new ArrayList<>();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TV t = new TV(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				listar.add(t);
	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listar;
	}

	@PostConstruct
	public List<TV>sports(){
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		List<TV>listar = null;
		String sql = "SELECT * FROM tvlist where genre = 'sports'";
		this.getConn();
		try {
			listar = new ArrayList<>();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TV t = new TV(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				listar.add(t);
	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listar;
	}
	
	@PostConstruct
	public List<TV>kids(){
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		List<TV>listar = null;
		String sql = "SELECT * FROM tvlist where genre = 'kids'";
		this.getConn();
		try {
			listar = new ArrayList<>();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TV t = new TV(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				listar.add(t);
	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listar;
	}
	
	@PostConstruct
	public List<TV>movies(){
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		List<TV>listar = null;
		String sql = "SELECT * FROM tvlist WHERE genre = 'movie'";
		this.getConn();
		try {
			listar = new ArrayList<>();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TV t = new TV(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				listar.add(t);
	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listar;
	}

	
	public TV getChannel(int id) {
		this.getConn();
		String sql = "SELECT * FROM tvlist WHERE id=?";
		TV t = null;
		try {
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new TV(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
}







