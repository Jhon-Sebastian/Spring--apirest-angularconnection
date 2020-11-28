package com.century.springboot.backend.apirest.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	// Authentication con Spring y Oauth2 a las rutas
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**").permitAll()

				/*
				 * .antMatchers(HttpMethod.GET,"/api/clientes/{id}").hasAnyRole("USER","ADMIN")
				 * .antMatchers(HttpMethod.POST,"/api/clientes").hasRole("ADMIN")
				 * .antMatchers(HttpMethod.PUT,"/api/clientes/{id}").hasRole("ADMIN")
				 * .antMatchers(HttpMethod.DELETE,"/api/clientes/{id}").hasRole("ADMIN")
				 */

				// Tambien se puede hacer y es mas sencillo para evitar poder uno por uno en PUT
				// y DELETE
				// .antMatchers("/api/clientes/**").hasRole("ADMIN")
				.anyRequest().authenticated().and().cors().configurationSource(corsConfigurationSource());
	}

	// Metodo encargado para el intercambio de informacion por las cabeceras entre
	// Spring y Angular con authorization
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

		CorsConfiguration config = new CorsConfiguration();
		// Permitir el dominio de los clientes (Angular,React etc)
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		// Metodos o verbos que se van a permitir en la aplicacion
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));// poner * para todos
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

		// Toda esa configuration para todas las rutas (endPoint) en el backend
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		// Primer argumento (Las rutas Backend) Segundo Argumento (La configuration)
		source.registerCorsConfiguration("/**", config);

		return source;
	}

	/*
	 * Registrar un filtro el cual va a esar en la prioridad mas alta en Spring para
	 * registrar el cors para no solo validar las rutas si no tambien los tokens
	 * cuando: en Login: [/Oauth-token] y cuando se envia el token al backend para
	 * autenticarlo
	 */

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(corsConfigurationSource()));
		// Entre mas bajo el orden mayor la prioridad
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
