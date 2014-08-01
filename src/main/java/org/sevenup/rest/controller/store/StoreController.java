package org.sevenup.rest.controller.store;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.core.domain.common.Store;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author steven.xu
 * 
 */
@Controller
@Produces(MediaType.APPLICATION_JSON)
public class StoreController {
	@RequestMapping(method = RequestMethod.GET, value = "stores")
	public ResponseEntity<Store> queryStores() {
		return new ResponseEntity<Store>(HttpStatus.BAD_GATEWAY);
	}
}
