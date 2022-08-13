package dao;

import Entidades.Time;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDao {

     private Connection con = null;
     private PreparedStatement st = null;
    // private List<Time> lista;
//INSERT-------------------------------------------------------------------------
    public void inserir(Time time) throws SQLException {
        String sql = "INSERT INTO tb_time (pontos,golFeito,golSofre) values(?,?,?)";
        
        try {
            Connection con = new ConnectionFactory().getConnection();
        PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, time.getPontos());
            st.setInt(2, time.getGolFeito());
            st.setInt(3, time.getGolSofre());
            st.execute();

            System.out.println("Inserido com sucesso!");
        } catch (SQLException ex) {
            throw new SQLException("Não foi possível inserir um Valor", ex);
        } finally {
            st.close();
            con.close();
        }
    }

//UPDATE -----------------------------------------------------------------------
    public void update(Integer id, Integer pontos) throws SQLException {

            String sql = "update tb_time set pontos = ?  where cd_time =?";
       
        try {
             Connection con = new ConnectionFactory().getConnection();
        PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, pontos);
            st.setInt(2, id);
            st.execute();                   //Professor filha da puta

            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {
            throw new SQLException("Não foi possível atualizar", ex);
        } finally {
            st.close();
            con.close();
        }
    }
//DELETE------------------------------------------------------------------------

    public boolean deletar(Integer id) throws SQLException {

        String sql = "DELETE FROM tb_time WHERE id = ?";
      

        try {
              Connection con = new ConnectionFactory().getConnection();
        PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
            System.out.println("Deletado com sucesso");
            return true;
        } catch (SQLException ex) {
            throw new SQLException("Não foi possível deletar um Time", ex);
        } finally {
            st.close();
            con.close();
        }

    }
//SELECT -----------------------------------------------------------------------

    public List<Time> consultarTodos() throws SQLException {

        String sql = "SELECT * FROM tb_time";
     
        ArrayList<Time> times = new ArrayList<>();

        try {
               Connection con = new ConnectionFactory().getConnection();
        PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //Integer id = rs.getInt("cd_time");
                String nome = rs.getString("nome");
                Integer pontos = rs.getInt("pontos");
                Integer golFeito = rs.getInt("golFeito");
                Integer golSofre = rs.getInt("golSofre");

                Time time = new Time();
                time.setCd_time(rs.getInt("cd_time"));
                time.setNome(nome);
                time.setPontos(pontos);
                time.setGolFeito(golFeito);
                time.setGolSofre(golSofre);

                times.add(time);

            }

        } catch (SQLException ex) {
            throw new SQLException("Não foi possível selecionar ", ex);
        } /*finally {
            st.close();
            con.close();
        }*/
        return times;

    }
}
