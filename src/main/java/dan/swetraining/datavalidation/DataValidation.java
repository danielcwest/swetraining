package dan.swetraining.datavalidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataValidation {
    
    public DataValidation() {

    }

    public boolean nullValueCheckPassed(double threshold){
        boolean result = false;

        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres", "changeme")){

            try(Statement stmt = con.createStatement()) {
                String nullValueSql = String.format("SELECT Sum( A.AUDIT_CHECK_PASSED_CNT ) AS AUDIT_CHECK_PASSED_CNT , Sum( A.AUDIT_CHECK_FAILED_CNT ) AS AUDIT_CHECK_FAILED_CNT FROM (SELECT CASE WHEN %2$s IS NOT NULL THEN 1.00 ELSE 0.00 END AS Audit_Check_Passed_cnt, CASE WHEN %2$s IS NULL THEN 1.00 ELSE 0.00 END AS Audit_Check_Failed_cnt FROM %1$s) A", "public.customer", "email_address");
                System.out.println(nullValueSql);
                try(ResultSet resultSet = stmt.executeQuery(nullValueSql)){
                    resultSet.next(); //Query should only return one row
                    double rowsNotNull = resultSet.getDouble("AUDIT_CHECK_PASSED_CNT");
                    double rowsNull = resultSet.getDouble("AUDIT_CHECK_FAILED_CNT");
                    double ratio = rowsNotNull / ( rowsNull + rowsNotNull);

                    return ratio > threshold;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
