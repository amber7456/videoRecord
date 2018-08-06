package com.videorecord.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.mybatis.pojo.VideoResourceInfo;

public class DBTest {

	public static void main(String[] args) throws SQLException, IOException {

		// List<VideoResourceInfo> list = getVr1();
		// for (int i = 0; i < list.size(); i++) {
		// if (list.get(i).getResource_remark() != null &&
		// list.get(i).getResource_remark().indexOf("_BD") < 0
		// && list.get(i).getResource_remark().length() > 0) {
		//
		// System.out.println(list.get(i).getVideo_id()+":"+list.get(i).getResource_remark());
		//
		// System.out.println(insertVideo("video_record", list.get(i)) );
		//
		// }
		// }

		List<VideoInfo> list = getAll();
		for (int i = 0; i < list.size(); i++) {

			String str = list.get(i).getVideo_type();
//			list.get(i).setVideo_type(str.split(";")[0]);
//			list.get(i).setVideo_season(str.split(";")[1]);
//
//			System.out.println(list.get(i).getVideo_id() + ":" + list.get(i).getVideo_type() + ":"
//					+ list.get(i).getVideo_season());

			System.out.println(updateVideo("video_record", list.get(i)));

		}
	}

	private static int updateVideo(String table, VideoInfo v) {
		Connection conn = getConn(table);
		String sql = "update video_info set video_season = '特别篇' where video_id = ? ";
		int i = 0;
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
//			pstmt.setString(1, v.getVideo_type());
//			pstmt.setString(2, v.getVideo_season());
			pstmt.setString(1, v.getVideo_id());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	//
	// @SuppressWarnings("unused")
	// private static List<VideoResourceInfo> getVr1() throws SQLException {
	// List<VideoResourceInfo> list = new ArrayList<VideoResourceInfo>();
	// Connection conn = getConn("video_record");
	// String sql = "SELECT * FROM video_resource_info";
	// PreparedStatement pstmt;
	// try {
	// pstmt = (PreparedStatement) conn.prepareStatement(sql);
	// ResultSet rs = pstmt.executeQuery();
	// int col = rs.getMetaData().getColumnCount();
	// ResultSetMetaData data = rs.getMetaData();
	// while (rs.next()) {
	// VideoResourceInfo vr = new VideoResourceInfo();
	// for (int i = 1; i <= col; i++) {
	// if (data.getColumnName(i).equals("video_id")) {
	// vr.setVideo_id(rs.getString(i));
	// } else if (data.getColumnName(i).equals("resource_remark")) {
	// vr.setResource_remark(rs.getString(i));
	// }
	// }
	// list.add(vr);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// conn.close();
	// }
	// return list;
	// }
	//
	// @SuppressWarnings("unused")
	// private static int insertVr(String table, VideoResourceInfo vr) {
	// Connection conn = getConn(table);
	// String sql = "insert into `video_resource_info`(`video_id`," +
	// "`resource_type`,`resource_format`,"
	// + "`resource_resolution`,`resource_sub`," +
	// "`resource_sub_type`,`resource_record_time`,"
	// + "`resource_record_address`,`resource_remark` ) values " +
	// "(?,?,?,?,?,?,?,?,?);";
	// int i = 0;
	//
	// PreparedStatement pstmt;
	// try {
	// pstmt = (PreparedStatement) conn.prepareStatement(sql);
	// pstmt.setString(1, vr.getVideo_id());
	// pstmt.setString(2, vr.getResource_type());
	// pstmt.setString(3, vr.getResource_format());
	// pstmt.setString(4, vr.getResource_resolution());
	// pstmt.setString(5, vr.getResource_sub());
	// pstmt.setString(6, vr.getResource_sub_type());
	// pstmt.setDate(7, (Date) vr.getResource_record_time());
	// pstmt.setString(8, vr.getResource_record_address());
	// pstmt.setString(9, vr.getResource_remark());
	//
	// i = pstmt.executeUpdate();
	// pstmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return i;
	// }
	//
	// @SuppressWarnings("unused")
	// private static List<VideoResourceInfo> getVr() throws SQLException {
	// List<VideoResourceInfo> list = new ArrayList<VideoResourceInfo>();
	// Connection conn = getConn("animation");
	// String sql = "SELECT * FROM animation_resource";
	// PreparedStatement pstmt;
	// try {
	// pstmt = (PreparedStatement) conn.prepareStatement(sql);
	// ResultSet rs = pstmt.executeQuery();
	// int col = rs.getMetaData().getColumnCount();
	// ResultSetMetaData data = rs.getMetaData();
	// while (rs.next()) {
	// VideoResourceInfo vr = new VideoResourceInfo();
	// for (int i = 1; i <= col; i++) {
	// if (data.getColumnName(i).equals("ANIMATION_ID")) {
	// vr.setVideo_id(rs.getString(i));
	// } else if (data.getColumnName(i).equals("RESOURCE_TYPE")) {
	// vr.setResource_type(rs.getString(i));
	// } else if (data.getColumnName(i).equals("RESOURCE_FORMAT")) {
	// vr.setResource_format(rs.getString(i));
	// } else if (data.getColumnName(i).equals("RESOURCE_IMAGE_RESOLUTION")) {
	// vr.setResource_resolution(rs.getString(i));
	// } else if (data.getColumnName(i).equals("RESOURCE_SUB")) {
	// vr.setResource_sub(rs.getString(i));
	// } else if (data.getColumnName(i).equals("RESOURCE_SUB_TYPE")) {
	// vr.setResource_sub_type(rs.getString(i));
	// } else if (data.getColumnName(i).equals("RESOURCE_TIME")) {
	// vr.setResource_record_time(rs.getDate(i));
	// } else if (data.getColumnName(i).equals("RESOURCE_ADDRESS")) {
	// vr.setResource_record_address(rs.getString(i));
	// } else if (data.getColumnName(i).equals("RESOURCE_REMARK")) {
	// vr.setResource_remark(rs.getString(i));
	// }
	// }
	// list.add(vr);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// conn.close();
	// }
	// return list;
	// }
	//
	private static Connection getConn(String table) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/" + table;
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	//
	private static List<VideoInfo> getAll() throws SQLException, IOException {
		List<VideoInfo> list = new ArrayList<VideoInfo>();
		Connection conn = getConn("video_record");
		String sql = "SELECT video_id, video_season " + "FROM video_info where video_season = \"其他\" ";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			ResultSetMetaData data = rs.getMetaData();
			System.out.println("============================");
			while (rs.next()) {

				VideoInfo videoInfo = new VideoInfo();

				for (int i = 1; i <= col; i++) {

					if (data.getColumnName(i).equals("video_id")) {
						if (rs.getString(i) != null && rs.getString(i).length() > 0) {
							videoInfo.setVideo_id(rs.getString(i));
						}
					}
					if (data.getColumnName(i).equals("video_type")) {
						if (rs.getString(i) != null && rs.getString(i).length() > 0) {
							videoInfo.setVideo_type(rs.getString(i));
						}
					}

				}
				list.add(videoInfo);

			}
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return list;
	}
	//
	// @SuppressWarnings("unused")
	// private static int insert(String table, VideoInfo v) {
	// Connection conn = getConn(table);
	// String sql = "insert into
	// `video_info`(`video_id`,`video_name`,`video_episode`,`video_broadcast_time`,`video_type`,`video_source`,`video_detail_info`,`video_remark`,`create_time`,`last_update_time`,`have_bd_resource`,`have_poster`)
	// values "
	// + "('" + v.getVideo_id() + "','" + v.getVideo_name() + "','" +
	// v.getVideo_episode() + "','"
	// + v.getVideo_broadcast_time() + "','" + v.getVideo_type() + "','" +
	// v.getVideo_source() + "',NULL,'1','"
	// + v.getLast_update_time() + "','" + v.getLast_update_time() + "','" +
	// v.getHave_bd_resource()
	// + "','0');";
	// int i = 0;
	//
	// PreparedStatement pstmt;
	// try {
	// pstmt = (PreparedStatement) conn.prepareStatement(sql);
	// i = pstmt.executeUpdate();
	// pstmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return i;
	// }

}
