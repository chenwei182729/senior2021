package sqlsession;

public interface Excutor {
    public <T> T query(String sql, Object parameter);
}
