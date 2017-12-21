package br.com.caelum.fj59.casadocodigo.controllers;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.fj59.casadocodigo.dao.DeviceDao;
import br.com.caelum.fj59.casadocodigo.model.Device;
import br.com.caelum.fj59.casadocodigo.webservice.WebClient;

@RestController
public class DeviceController {


	@Autowired
	private DeviceDao dao;
	
	@Autowired
	private WebClient client;

	@Transactional
	@RequestMapping("/device/register/{email}/{id}")
	public String home(@PathVariable("email") String email, @PathVariable("id") String id) throws IOException {

		Device device = new Device(email, id);

		dao.salva(device);

		return "Sucesso";
	}
	
	@Transactional
	@RequestMapping("/device/lancaFirebase")
	public String enviaNotificacao() throws IOException{
		
		List<Device> devices = dao.lista();
		
		for(Device device : devices){
			client.sobeParaFirebase(device.getId());
		}
			
		return "Sucesso";
	}

	

}
