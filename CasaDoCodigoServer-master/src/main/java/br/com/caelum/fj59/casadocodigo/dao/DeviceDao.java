package br.com.caelum.fj59.casadocodigo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.fj59.casadocodigo.model.Device;

@Repository
public class DeviceDao {

	@PersistenceContext
	private EntityManager manager;

	public void salva(Device device) {
		manager.persist(device);
	}

	public List<Device> lista() {
		// TODO Auto-generated method stub
		return manager.createQuery("select d from Device d", Device.class).getResultList();
	}

}
