package spring.contactApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee implements UserDetails {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Email
    @Column(nullable = false,unique =true)
    private String email;

    @Column(nullable = false)
    private String password;


    @Column(updatable = false,nullable = false)
    @CreationTimestamp
    private Timestamp createAt;

    @UpdateTimestamp
    private Timestamp updateAt;

    @OneToOne
    private Branch branch;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    private Role role;

    @OneToOne
    private PassportInfo passportInfo;

    @OneToOne
    private Company company;

    private boolean accountNonExpired = true;//BU USERNING AMALQILISH MUDDATI O'TIB KETMAGAN.
    private boolean accountNonLocked = true;//BU USER BLOKLANMAGANLIGI.
    private boolean credentialsNonExpired = true; //
    private boolean enabled = false;

    private String emailCode;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
