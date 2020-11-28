package com.century.springboot.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.century.springboot.backend.apirest.models.entity.Usuario;
import com.century.springboot.backend.apirest.models.services.UsuarioService;

@Component
public class InfoAditionalToken implements TokenEnhancer{

	@Autowired
	private UsuarioService usuario;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>();
		Usuario user = usuario.findByUsername(authentication.getName());
		info.put("info_aditional", "Hola que tal: ".concat(authentication.getName()));
		
		info.put("nombre", "Hola que tal: " + user.getNombre());
		info.put("apellido", "Hola que tal: " + user.getApellido());
		info.put("email", "Hola que tal: " + user.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
