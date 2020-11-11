package pe.sysrasoc.Service;

import java.util.Map;

import pe.sysrasoc.Entity.Mantener_Cargo;

public interface Mantener_CargoService {
	int create(Mantener_Cargo c);
	int update(Mantener_Cargo c);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();

}
