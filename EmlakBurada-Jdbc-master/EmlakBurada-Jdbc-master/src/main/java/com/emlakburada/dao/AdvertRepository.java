package com.emlakburada.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emlakburada.entity.Advert;


public class AdvertRepository extends JdbcConnectionRepository {

	

	private static final String INSERT_ADVERT = "INSERT INTO ADVERT (ID, ADVERTNO, BASLIK) VALUES (?,?,?);";
	private static final String SELECT_ALL_ADVERT = "SELECT * FROM ADVERT";
	private static final String FIND_ADVERT = "SELECT * FROM ADVERT WHERE id = ?";

	private Advert advertPrepare(int id, int advertNo, String baslik) {
		
		Advert advert = new Advert();

		advert.id = id;
		advert.advertNo = advertNo;
		advert.baslik = baslik;
		

		return advert;

}
	

	public void saveAdvert(Advert advert) {

		Connection connection = connect();

		if (connection != null) {

			PreparedStatement prepareStatement = null;
			try {

				prepareStatement = connection.prepareStatement(INSERT_ADVERT);
				prepareStatement.setInt(1, advert.id);
				prepareStatement.setInt(2, advert.advertNo);
				prepareStatement.setString(3,advert.baslik);
				

				int executeUpdate = prepareStatement.executeUpdate();

				System.out.println("result: " + executeUpdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Connection oluşturululamadı!");
		}

	}
	
	public List<Advert> findAll() {

		List<Advert> advertList = new ArrayList<Advert>();

		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_ADVERT);

			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {

				int id = result.getInt("id");
				int advertNo = result.getInt("advertNo");
				String baslik = result.getString("baslik");
			

				advertList.add(advertPrepare(id,advertNo,baslik));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return advertList;

	}
	
	
	public Advert findOne(int id) {

		Advert advert = null;

		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADVERT);
			prepareStatement.setInt(1, id);

			ResultSet result = prepareStatement.executeQuery();
			if (result.next()) {
				int id1 = result.getInt("id");
				int advertNo = result.getInt("advertNo");
				String baslik = result.getString("baslik");
				

				advert = advertPrepare(id1, advertNo, baslik);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return advert;

	}



}
