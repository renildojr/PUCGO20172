package ex001xml;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Main {
public static void main(String[] args) {
	
	Universidade uni = new Universidade();
	uni.setId(222);
	uni.setNome("PUCGO");
	uni.setEndereco("rua 10");
	uni.setSigla("puc");
	uni.setSite("puc@puc.com");
	
	Professor prof = new Professor();
	prof.setCpf("123123123");
	prof.setId(333);
	prof.setNome("fulano");
	
	Sala sala = new Sala();
	sala.setArea("a");
	sala.setId(12);
	sala.setNumero("5656");
	sala.setTipo("abc");
	
	Aluno aluno = new Aluno();
	aluno.setCpf("321312321");
	aluno.setData_nasc("19900101");
	aluno.setEndereco("rua rio verde");
	aluno.setId(8989);
	aluno.setNome("ALUNO001");
	
	Dados dados = new Dados();
	dados.setUniversidade(uni);
	dados.setProfessor(prof);
	dados.setSala(sala);
	dados.setAluno(aluno);
	
	XStream xstream = new XStream();
	xstream.alias("universidade", Universidade.class);
	xstream.alias("professor", Professor.class);
	xstream.alias("sala", Sala.class);
	xstream.alias("aluno", Aluno.class); 
	String xml = xstream.toXML(dados);
	System.out.println(xml);
	
	XStream xstream2 = new XStream(new StaxDriver());
	
	xstream2.alias("universidade", Universidade.class);
	xstream2.alias("professor", Professor.class);
	xstream2.alias("sala", Sala.class);
	xstream2.alias("aluno", Aluno.class); 
	Dados dados2 = (Dados)xstream2.fromXML(xml);
	//Universidade uni2 = (Universidade)xstream2.fromXML(xml);
	//System.out.println(uni2.getNome());
		 
	}
}
