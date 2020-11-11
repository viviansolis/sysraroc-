package pe.sysrasoc.Dao;

import java.util.Map;

import pe.sysrasoc.Entity.Mantener_Cargo;

public interface Mantener_CargoDao {
	int create (Mantener_Cargo c);
	int update (Mantener_Cargo c);
	int delete (int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	void convertitMap(Map<String, Object> map);

}
