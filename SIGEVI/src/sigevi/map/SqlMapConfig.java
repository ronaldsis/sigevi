package sigevi.map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.IOException;
import java.io.Reader;

public class SqlMapConfig {

    protected static final SqlMapClient sqlMap;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("sigevi/map/SqlMapConfig.xml");
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
        } catch (IOException e) {
            throw new RuntimeException(
                    "IO Exception: ", e);
        } catch (Exception e) {
            throw new RuntimeException("Exception Fatal Error: ", e);
        }
    }

    public static SqlMapClient getSqlMap() {
        return sqlMap;
    }
}