package by.tms.buildCalc.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Objects;

//@Data
@Entity
//@Table(name = "USERS")
//@NamedQueries({
//		@NamedQuery(name = "Users.findUserByEmail",
//				query = "select u from User u where u.email = :email")})
public class User {

//	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(name = "NAME")
	@Size(min = 2, message = "Имя должно содержать не менее 2-х букв")
	private String name;

//	@Column(name = "AGE")
	@Max(value = 60, message = "Возраст должен быть не более 60")
	@Min(value = 10, message = "Возраст должен быть не ненее 10")
	private Integer age;

//	@Column(name = "EMAIL")
	@Email(message = "Введите вашу электронную почту")
	private String email;

//	@Column(name = "PASS")
	@Size(min = 3, max = 8, message = "Введите пароль от 3 до 8 символов")
	private String pass;

	public User(Long id, String name, Integer age, String email, String pass) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.pass = pass;
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Пользователь " + name + " | Возраст : " + age + " | E-Mail : " + email + " (id-" + id + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) &&
				Objects.equals(name, user.name) &&
				Objects.equals(age, user.age) &&
				Objects.equals(email, user.email) &&
				Objects.equals(pass, user.pass);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, age, email, pass);
	}
}
