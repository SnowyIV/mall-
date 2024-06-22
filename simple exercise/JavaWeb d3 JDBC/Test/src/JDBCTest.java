import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        loadEmployeeWithJobs();
        loadDeptPeople();
    }

    /**
     * 1.查询所有员工信息。查询员工编号，员工姓名，工资，职务名称，职务描述
     */
        private static void loadEmployeeWithJobs() {

            String sql = "SELECT * FROM emp , job where " +
                    "emp.job_id = job.id;";
            try (Connection connection = SqlUtil.getConnection();
                 Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(sql);
            ) {

                while (rs.next()) {
                    System.out.print(rs.getString("ename") + " ");
                    System.out.print(rs.getString("jname") + " ");
                    System.out.println(rs.getString("description"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    /**
     * 查询出部门编号、部门名称、部门位置、部门人数
     */
    private static void loadDeptPeople() {

        String sql = "SELECT " +
                "dept.*, COUNT(*) AS cnt " +
                "FROM " +
                "dept, " +
                "emp " +
                "WHERE " +
                "dept.id = emp.dept_id " +
                "GROUP BY emp.dept_id " +
                "ORDER BY cnt DESC";
        try (Connection connection = SqlUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {
                System.out.print(rs.getString("dname") + " ");
                System.out.print(rs.getString("cnt") + " ");
                System.out.println(rs.getString("loc") + " ");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    }

