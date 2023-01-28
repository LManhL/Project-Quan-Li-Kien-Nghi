package com.example.projectquanlikiennghi;


import com.example.projectquanlikiennghi.models.Account;
import com.example.projectquanlikiennghi.models.KienNghi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// load database
public class  JdbcDAO {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/btl_cnpm";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Vykroos280502.";


    private static final String LOAD_USER = "SELECT * FROM account";
    private static final String LOAD_KN = "SELECT * FROM kiennghi";
    private static final String LOAD_KN_CHUAPD = "SELECT * FROM kiennghi WHERE Trangthai = 0";
    private static final String LOAD_KN_DAPD = "SELECT * FROM kiennghi WHERE Trangthai = 1";


    private static final String COUNT_USER = "SELECT count(CCCD) FROM account;";
    private static final String COUNT_KN = "SELECT count(Ma_kien_nghi) FROM kiennghi";
    private static final String COUNT_KN_CHUAPD = "SELECT count(Ma_kien_nghi) FROM kiennghi WHERE Trangthai = 0";
    private static final String COUNT_KN_DAPD = "SELECT count(Ma_kien_nghi) FROM kiennghi WHERE Trangthai =1";

    private static final String CHECK_LOGIN_USER="SELECT username,password from account";


    public static Connection ConnectDB() throws SQLException {
        Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        return connection;
    }

    // count for user
    // dem so nguoi dan
    public int count_user() throws SQLException {
        Connection connection = ConnectDB();

        ResultSet rs = connection.createStatement().executeQuery(COUNT_USER);
        rs.next();
        int ans = rs.getInt(1);
        return ans;
    }
    // count for KN
    // dem so kien nghi
    public int count_KN() throws SQLException {
        Connection connection = ConnectDB();

        ResultSet rs = connection.createStatement().executeQuery(COUNT_KN);
        rs.next();
        int ans = rs.getInt(1);
        return ans;
    }
    // count for KN chua PD
    // so kien nghi chua phan hoi
    public int count_KN_chuaPD() throws SQLException {
        Connection connection = ConnectDB();

        ResultSet rs = connection.createStatement().executeQuery(COUNT_KN_CHUAPD);
        rs.next();
        int ans = rs.getInt(1);
        return ans;
    }
    // count for KN da PD
    public int count_KN_daPD() throws SQLException {
        Connection connection = ConnectDB();

        ResultSet rs = connection.createStatement().executeQuery(COUNT_KN_DAPD);
        rs.next();
        int ans = rs.getInt(1);
        return ans;
    }

    // return List User
    public ObservableList<Account> listUser() throws SQLException{
        ObservableList<Account> list = FXCollections.observableArrayList();
        Connection connection = ConnectDB();

        ResultSet result = connection.createStatement().executeQuery(LOAD_USER);
        while (result.next()) {
            list.add(new Account(list.size()+1, result.getObject(1).toString(),
                    result.getObject(2).toString(), result.getObject(3).toString(),
                    result.getObject(4).toString(), result.getObject(5).toString(),
                    result.getObject(6).toString(), result.getObject(7).toString(),0));
        }
        connection.close();
        return list;
    }

    // danh sach tat ca kien nghi
    public ObservableList<KienNghi> listKN() throws SQLException{
        ObservableList<KienNghi> list = FXCollections.observableArrayList();
        Connection connection = ConnectDB();

        ResultSet result = connection.createStatement().executeQuery(LOAD_KN);
        while (result.next()) {
            list.add(new KienNghi(list.size()+1,String.valueOf(result.getObject(1)), String.valueOf(result.getObject(2)),
                    String.valueOf(result.getObject(3)), result.getInt(4),
                    String.valueOf(result.getObject(5)), String.valueOf(result.getObject(6)),
                    String.valueOf(result.getObject(7))));

        }
        connection.close();
        return list;
    }
    // danh sach kien nghi chua phe duyet
    public ObservableList<KienNghi> listKN_chuaPD() throws SQLException{
        ObservableList<KienNghi> list = FXCollections.observableArrayList();
        Connection connection = ConnectDB();

        ResultSet result = connection.createStatement().executeQuery(LOAD_KN_CHUAPD);
        while (result.next()) {
            list.add(new KienNghi(list.size()+1,String.valueOf(result.getObject(1)), String.valueOf(result.getObject(2)),
                    String.valueOf(result.getObject(3)), result.getInt(4),
                    String.valueOf(result.getObject(5)), String.valueOf(result.getObject(6)),
                    String.valueOf(result.getObject(7))));

        }
        //connection.close();
        return list;
    }
    // danh sach kien nghi da phe duyet cho phan hoi
    public ObservableList<KienNghi> listKN_daPD() throws SQLException{
        ObservableList<KienNghi> list = FXCollections.observableArrayList();
        Connection connection = ConnectDB();

        ResultSet result = connection.createStatement().executeQuery(LOAD_KN_DAPD);
        while (result.next()) {
            list.add(new KienNghi(list.size()+1,String.valueOf(result.getObject(1)), String.valueOf(result.getObject(2)),
                    String.valueOf(result.getObject(3)), result.getInt(4),
                    String.valueOf(result.getObject(5)), String.valueOf(result.getObject(6)),
                    String.valueOf(result.getObject(7))));

        }
        //connection.close();
        return list;
    }
    // them user
    public void InsertUser(Account acc) throws SQLException {
        Connection connection = ConnectDB();

        Statement st = connection.createStatement();

        String hoten = acc.getHovaten();
        String sdt = acc.getSDT();
        String diachi = acc.getDiachi();
        String gioitinh = acc.getGioitinh();
        String namsinh = acc.getNamsinh();
        String cccd = acc.getCCCD();
        String username = acc.getUsername();
        String password = "123456";
        String role = "user";
        String sql="INSERT INTO account VALUES ("+"'"+hoten+"','"+sdt +"','"+ diachi+"','"
                + gioitinh +"','" + namsinh + "','"+ cccd +"','"
                +username+ "','"+ password +"','"+role + "')";
        System.out.println(sql);
        st.executeUpdate(sql);

        connection.close();
    }
    // thay doi trang thai kien nghi
    public void updateStatus(KienNghi KN, int stt) throws SQLException {
        String maKn = KN.getMa_kien_nghi();
        Connection connection = ConnectDB();
        Statement st = connection.createStatement();

        String sql = "UPDATE kiennghi SET Trangthai = " + stt + " WHERE (Ma_kien_nghi = '"+ maKn +"')"  ;
        st.executeUpdate(sql);
    }
    // them phan hoi kien nghi
    public void updatePhanHoi(KienNghi KN, String ngayphanhoi,
                              String NDPH, String CQPH) throws SQLException{
        String maKn = KN.getMa_kien_nghi();
        Connection connection = ConnectDB();
        Statement st = connection.createStatement();

        String sql = "UPDATE kiennghi SET Ngayphanhoi = " + "'"+ngayphanhoi+"'" +
                     " , Noidungphanhoi = " + "'"+NDPH+"'"+
                     " WHERE (Ma_kien_nghi = '"+ maKn +"')"  ;
        System.out.println(sql);

        st.executeUpdate(sql);
    }

    // kiem tra thong tin dang nhap
    public Map<String,String> checkloginUser() throws  SQLException {
        Map<String,String> map = new HashMap<>();
        Connection connection = ConnectDB();
        ResultSet result = connection.createStatement().executeQuery(CHECK_LOGIN_USER);

        while (result.next()) {
            map.put(result.getObject(1).toString(),result.getObject(2).toString());
        }
        return map;
    }

    // lay tat ca thong tin cua user
    public Account loadUserInformation(String username,String password) throws SQLException {
        String query = "SELECT * from account WHERE username= "+"'"+username+"'"+" AND "+ "password="+"'"+password+"'";
        Connection connection = ConnectDB();
        ResultSet result = connection.createStatement().executeQuery(query);
        result.next();
        Account account=new Account(result.getObject(1).toString(),result.getObject(2).toString(),
                                    result.getObject(3).toString(),result.getObject(4).toString(),
                                    result.getObject(5).toString(),result.getObject(6).toString(),
                                    result.getObject(7).toString(),result.getObject(8).toString(),
                                    result.getObject(9).toString());
        return account;
    }

    // lay kien nghi cua 1 user
    public ObservableList<KienNghi> getKienNghiuser(String username, String password) throws SQLException {
        Account acc = loadUserInformation(username,password);
        String query = "select kn.Ma_kien_nghi , kn.Ngaygui, kn.Noidung, kn.Trangthai, kn.Noidungphanhoi, kn.Ngayphanhoi, kn.Loai  \n" +
                "from acc_kiennghi akn , kiennghi kn\n" +
                "where akn.Ma_kien_nghi = kn.Ma_kien_nghi and akn.CCCD ='"+acc.getCCCD()+"'";
        Connection connection = ConnectDB();
        ResultSet result = connection.createStatement().executeQuery(query);
        ObservableList<KienNghi> list = FXCollections.observableArrayList();
        while (result.next()) {
            System.out.println(result.getObject(6));
            list.add(new KienNghi(list.size()+1,String.valueOf(result.getObject(1)), String.valueOf(result.getObject(2)),
                    String.valueOf(result.getObject(3)), result.getInt(4),
                    String.valueOf(result.getObject(5)), String.valueOf(result.getObject(6)),
                    String.valueOf(result.getObject(7))));

        }
        return list;
    }

    public void delete_kn(String str) throws SQLException {
        String query ="delete from kiennghi where Ma_kien_nghi='"+str+"'";
        Connection connection = ConnectDB();
        ResultSet result = connection.createStatement().executeQuery(query);
    }

    public  void add_kn_of_user(String name, String pass,String mkn, String ng,String nd,String loai) throws SQLException {
        Account acc = loadUserInformation(name,pass);
        String add_acc_kn ="insert into acc_kiennghi\n" +
                "values ('"+acc.getCCCD()+"','"+mkn+"')";
        String add_kn ="insert into kiennghi\n" +
                "values ('"+mkn+"','"+ng+"','"+nd+"','0','','','"+loai+"')";
        Connection connection = ConnectDB();
        ResultSet result = connection.createStatement().executeQuery(add_acc_kn);
        ResultSet result1 = connection.createStatement().executeQuery(add_kn);

    }

}
