//Curso de SpringBoot 
//Aula Atual 13


//Usado até o java 7, não existe mais no Spring JPA
//Agora ele só aceita java 8.0 ou maior, sendo assim usar a função abaixo.
public Categoria find(Integer id) {
	Categoria obj = repo.findOne(id);
	return obj;
}

//Troque o import pelo seguinte código, (import java.util.OptionalDataException
//O java optional é um recurso do JAVA 8.0 que faz a parte de encapsular um objeto
//para que o mesmo possa ser testado se esta nulo ou não sem dar null poiter exception
public Categoria find(integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
}
	

