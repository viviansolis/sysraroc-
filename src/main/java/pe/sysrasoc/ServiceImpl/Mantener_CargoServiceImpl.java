package pe.sysrasoc.ServiceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sysrasoc.Dao.Mantener_CargoDao;
import pe.sysrasoc.Entity.Mantener_Cargo;
import pe.sysrasoc.Service.Mantener_CargoService;
@Service

public class Mantener_CargoServiceImpl implements Mantener_CargoService {
@Autowired

private Mantener_CargoDao cargoDao;
	@Override
	public int create(Mantener_Cargo c) {
		// TODO Auto-generated method stub
		return cargoDao.create(c);
	}

	@Override
	public int update(Mantener_Cargo c) {
		// TODO Auto-generated method stub
		System.out.println("Service: " + c.getNombre_cargo());
		return cargoDao.update(c);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return cargoDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return cargoDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return cargoDao.readAll();
	}

}
