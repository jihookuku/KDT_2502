package kr.co.himedia.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtils {
	private static SecretKey pri_key = null;

	// Getter
	public static SecretKey getPri_key() {
		return pri_key;
	}

	// Setter로는 새로운 키를 생성해야한다
	public static void setPri_key() {
		JwtUtils.pri_key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}

	// 토큰을 생성하는 코드
	public static String setToken(Map<String, Object> map) {
		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT").setClaims(map)
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 10)))
				.signWith(pri_key).compact();
	}

	// 오버로드하기힘들어요흑흑흑 아 해야해............
	// 오버로드! 키, 갚으로 하나의 데이터만 만들 경우를 대비했대
	public static String setToken(String key, Object value) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		return setToken(map);
	}

	// payload(body)를 읽어서 토큰을 검증하는 코드
	public static Map<String, Object> readToken(String token) {
		Map<String, Object> resp = new HashMap<String, Object>();

		try {
			Claims claims = Jwts.parserBuilder().setSigningKey(pri_key).build().parseClaimsJws(token).getBody();
			// Claims 인터페이스는 Map 형태랜다
			for (String key : claims.keySet()) {
				resp.put(key, claims.get(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("id", "");
		}
		return resp;
	}

}
