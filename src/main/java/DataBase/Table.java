package DataBase;

import MODEL.*;
import java.sql.*;

public class Table {
    public void createTables() {

        String url = "jdbc:sqlite:C:\\Users\\maria\\Desktop\\DACD\\actvspotify\\database.db";

        String sqlArtists = "CREATE TABLE IF NOT EXISTS artists (\n"
                + "	id String,\n"
                + "	name String NOT NULL,\n"
                + "	popularity int,\n"
                + " genres String\n"
                + ");";

        String sqlAlbums = "CREATE TABLE IF NOT EXISTS albums (\n"
                + "	albumId String,\n"
                + "	albumName String NOT NULL,\n"
                + "	totalTracks int,\n"
                + " albumType String\n"
                + ");";


        String sqlTracks = "CREATE TABLE IF NOT EXISTS tracks (\n"
                + "	trackId String,\n"
                + "	trackName String NOT NULL,\n"
                + " duration String, \n"
                + "	explicit Boolean\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlArtists);
            stmt.execute(sqlAlbums);
            stmt.execute(sqlTracks);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertArtist(Artist artist1, Connect connection) throws SQLException {

        String sql = "INSERT INTO artists(id, name, popularity, genres) VALUES(?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, artist1.getId());
            pstmt.setString(2, artist1.getName());
            pstmt.setInt(3, artist1.getPopularity());
            pstmt.setString(4, artist1.getGenres());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAlbum(Album album1, Connect connection) throws SQLException {
        String sql = "INSERT or IGNORE INTO albums(albumId, albumName, totalTracks, albumType) VALUES(?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, album1.getId());
            pstmt.setString(2, album1.getName());
            pstmt.setInt(3, album1.getTotalTracks());
            pstmt.setString(4, album1.getAlbumType());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertTrack(Track track1, Connect connection) throws SQLException {
        String sql = "INSERT INTO tracks(trackId, trackName, duration, explicit) VALUES(?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, track1.getId());
            pstmt.setString(2, track1.getName());
            pstmt.setInt(3, track1.getDuration());
            pstmt.setBoolean(4, track1.getExplicit());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
