package by.tms.buildCalc.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
@NamedQueries({
		@NamedQuery(name = "User.findUserByEmailAndPass", query = "select u from User u where u.email = :email and u.pass = :pass"),
		@NamedQuery(name = "User.findUserByEmail", query = "select u from User u where u.email = :email"),
		@NamedQuery(name = "User.findAllUsers", query = "select u from User u")
})

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
//	@Pattern(regexp = "[/d]", message = "Вы ввели недопустимое имя")
	@Size(min = 2, message = "Имя должно содержать не менее 2-х букв")
	private String name;

	@Column(name = "age")
	@Max(value = 60, message = "Возраст должен быть не более 60")
	@Min(value = 10, message = "Возраст должен быть не ненее 10")
	private Integer age;

	@Column(name = "email", unique = true)
	@Email(message = "Введите вашу электронную почту")
	private String email;

	@Column(name = "pass")
	@Size(min = 3, max = 8, message = "Введите пароль от 3 до 8 символов")
	private String pass;
}
