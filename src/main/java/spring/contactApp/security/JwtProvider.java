package spring.contactApp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import spring.contactApp.entity.Role;

import java.util.Date;

@Component
public class JwtProvider {
    private static final long expireTime = 1000*60*60*24;
    private static final String securityKey = "bumaxfiykalitsozhisoblanadibunihechkimbilmasligilozim";

    public String generateToken(String username, Role role){
        Date expireDate = new Date(System.currentTimeMillis()+expireTime);
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
        return token;
    }

    public String getUserNameForToken(String token) {
        try{
            String username = Jwts
                    .parser()
                    .setSigningKey(securityKey)
                    .parseClaimsJws(token)
                    .getBody().getSubject();
            return username;
        }catch (Exception e){
            return null;
        }
    }
}
