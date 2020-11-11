package pe.sysrasoc.DaoImpl;

import java.util.Map;
import java.util.Map.Entry;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import oracle.jdbc.internal.OracleTypes;
import pe.sysrasoc.Dao.Mantener_CargoDao;
import pe.sysrasoc.Entity.Mantener_Cargo;
@Component
public class Mantener_CargoDaoImpl implements Mantener_CargoDao{
@Autowired
private JdbcTemplate jdbcTemplate;
private SimpleJdbcCall simpleJdbcCall;
@Override
public int create(Mantener_Cargo c) {
	// TODO Auto-generated method stub
	System.out.println(c.getNombre_cargo());
	String sql="declare v_car cargo%rowtype; begin v_car.nombre_cargo:=?;  pk_cargo.sp_ins_cargo(v_car); end;";
	return jdbcTemplate.update(sql,c.getNombre_cargo());
}
@Override
public int update(Mantener_Cargo c) {
	// TODO Auto-generated method stub
	System.out.println(c.getNombre_cargo());
	String sql="declare v_car cargo%rowtype; begin v_car.id_cargo:=?; v_car.nombre_cargo:=?;  pk_cargo.sp_upd_cargo(v_car); end;";
	return  jdbcTemplate.update(sql,c.getId_cargo(),c.getNombre_cargo());
}
@Override
public int delete(int id) {
	// TODO Auto-generated method stub
	return jdbcTemplate.update("call pk_cargo.sp_delete_cargo(?)", id);

}
@Override
public Map<String, Object> read(int id) {
	System.out.println(id); 
	simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
	.withCatalogName("pk_cargo") //nombre del paquete
	.withProcedureName("sp_read_cargo") //nombre del procedimiento
	.declareParameters(new SqlOutParameter("cursor_cargo", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("idcargo", OracleTypes.NUMBER));
	SqlParameterSource in = new MapSqlParameterSource().addValue("idcargo", id);
/*		Map<String, Object> out= simpleJdbcCall.execute(in);	
	out.forEach((rol, nomrol)->{
		System.out.println(rol+"aaa "+nomrol);
	});*/
	return simpleJdbcCall.execute(in);
}
@Override
public Map<String, Object> readAll() {
	simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withCatalogName("pk_cargo") //nombre del paquete
			.withProcedureName("sp_listar_cargo") //nombre del procedimiento
			.declareParameters(new SqlOutParameter("cursor_cargo", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
	
	return simpleJdbcCall.execute();
}
@Override
public void convertitMap(Map<String, Object> map) {
	// TODO Auto-generated method stub
	Mantener_Cargo cargo = new Mantener_Cargo();
	for (Entry<String, Object> entry : map.entrySet()) {
        System.out.println("entry key : "+entry.getKey());
        System.out.println("Object value :"+entry.getValue());     
        System.out.println("Object value :"+entry.getClass().toString());     
	}
	
}



}
