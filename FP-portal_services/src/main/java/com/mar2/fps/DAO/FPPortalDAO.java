package com.mar2.fps.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mar2.fps.DTO.FPPortalDTO;

@Repository
public class FPPortalDAO {
	private static Map<Integer, FPPortalDTO> map = new HashMap<Integer, FPPortalDTO>();
	
	static{
		FPPortalDTO fp1 = new FPPortalDTO();
		fp1.setId(100);
		fp1.setVendor("V_ABC");
		fp1.setClient("C_ABC");
		fp1.setUrl("http://abc.com");
		
		FPPortalDTO fp2 = new FPPortalDTO();
		fp2.setId(200);
		fp2.setVendor("V_XYXC");
		fp2.setClient("C_XYZ");
		fp2.setUrl("http://xyz.com");
		
		map.put(fp1.getId(), fp1);
		map.put(fp2.getId(), fp2);
	}
	
	
	public Map<Integer, FPPortalDTO> getMap(){
		return map;
	}
}
