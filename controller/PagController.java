package com.firstsoftware.software.controller;

import com.firstsoftware.software.entity.*;
import com.firstsoftware.software.repository.*;

import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class PagController {

    @Autowired
    private RuaRepository ruaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private UfRepository ufRepository;
    @Autowired
    private BairroRepository bairroRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private  ServicoReposiory servicoReposiory;
    @Autowired
    private  FornecedorRepository fornecedorRepository;




    @RequestMapping("/")
    public String cadastrar(){
        return"Home";
    }

    @RequestMapping(value = "salvar",method = RequestMethod.POST)
    public String salvar( @RequestParam("nome") String nome, @RequestParam("cpf") String cpf,
                         @RequestParam("senha")String senha,@RequestParam("email")String email,Model model){


        Usuario usuario= new Usuario(cpf,nome,senha,email,1);
        usuarioRepository.save(usuario);
        model.addAttribute("user",usuario);
        return this.cadastrar();
    }


    @RequestMapping(value="logar",method=RequestMethod.POST)
    public String logar(@RequestParam("cpf")String cpf, @RequestParam("senha")String senha,
                        HttpSession session, HttpServletRequest request){

        Optional<Usuario> userLogin=usuarioRepository.findById(cpf);
        session=request.getSession();
        Usuario user= userLogin.get();
        if(user.getSenha().equals(senha)){
            Usuario userLogado=new Usuario(user.getCpf(),user.getNome_usuario(),user.getSenha(),user.getEmail(),user.getTipoUsuario());
            session.setAttribute("userLogado",userLogado);

            return "/List";
        }else{
            return "/";
        }
    }
    @RequestMapping(value = "/CadastrarServico",method = RequestMethod.GET)
    public String TelacadastroDeServico(){

        return "CadastrarServico";
    }


    @RequestMapping(value="CadastrarS",method = RequestMethod.POST)
    public String cadastrarServico(@RequestParam ("rua")String rua, @RequestParam("complemento")String complemento,
                                   @RequestParam("estado")String estado, @RequestParam("nome")String nome,
                                   @RequestParam("numeroPessoas")int numeroPessoas, @RequestParam("cidade")String cidade,
                                   @RequestParam("bairro") String bairro, @RequestParam("descricao")String descricao,
                                   @RequestParam("data") String data,
                                   @RequestParam("valor") float valor, @RequestParam("horario")String horario,
                                   HttpSession session,@ModelAttribute("categoria") Categoria categoria,HttpServletRequest request) {


        try {
            Rua ruaServico = ruaRepository.findByNome(rua);
            Cidade cidadeServico = cidadeRepository.findByNome(cidade);
            Integer categoriaServico = categoria.getId();
            Local localServico = new Local(complemento, (ruaServico.getId()), (cidadeServico.getId()));

            session=request.getSession();
            Usuario user=(Usuario) session.getAttribute("userLogado");


            localRepository.save(localServico);
            Servico servico = new Servico(nome, user.getCpf(), localServico.getId(), numeroPessoas, descricao, categoriaServico, new Date(),
                    data, valor, horario);
            servicoReposiory.save(servico);
        } catch (Exception e) {
            e.printStackTrace();
            return "/CadastrarServico";
        }


        return "/List";
    }
    @RequestMapping("/List")
    public String listar(){
        return "List";
    }

    @RequestMapping("/CadastroFornecedor")
    public String crudFornecedor(HttpServletRequest request){
        Usuario userLogado=this.userLogado(request);
        if(userLogado.getTipoUsuario()==1)
            return "CadastroFornecedor";
        else
            return this.TelacadastroDeServico();
    }

    @RequestMapping(value = "cadastrarFornecedor",method = RequestMethod.POST)
    public String cadastrarFornecedor(HttpServletRequest request,@RequestParam ("area")String area,@RequestParam("descricao")String descricao,
                                      @RequestParam("numero")int numeroConta,@RequestParam("agencia")String agencia,
                                      @RequestParam("banco") String banco,HttpSession session){

        Conta contaFornecedor=new Conta( numeroConta,banco,agencia);
        contaRepository.save(contaFornecedor);
        Usuario userLogado=this.userLogado(request);
        Fornecedor fornecedor=new Fornecedor(userLogado.getCpf(),contaFornecedor.getNumero(),area,descricao);
        fornecedorRepository.save(fornecedor);
        userLogado.setTipoUsuario(2);
        usuarioRepository.save(userLogado);

        return "/CadastrarServico";
    }
    @RequestMapping(value = "DetalhesServico",method = RequestMethod.GET)
    public String DetalharServico(Model model,){

    }

    @ModelAttribute("uf")
    public ArrayList<Uf> getUfs(){

        ArrayList<Uf> uf=new ArrayList<>();
        Iterable <Uf> ufs=ufRepository.findAll();
        for(Uf es :ufs){
            uf.add(es);
        }

        return uf;
    }
    @ModelAttribute("categoria")
    public ArrayList<Categoria> getCategorias(){
        ArrayList<Categoria> categoria=new ArrayList<>();
        Iterable<Categoria> categorias=categoriaRepository.findAll();

        for(Categoria categoria1:categorias){
            categoria.add(categoria1);
        }
        return categoria;
    }
    @ModelAttribute("Servicos")
    public ArrayList<Servico> getServicos(){
        ArrayList<Servico> servicos=new ArrayList<>();
        Iterable <Servico> todos=servicoReposiory.findAll();

        for(Servico s:todos){
            servicos.add(s);
        }

        return servicos;
    }

    public Usuario userLogado(HttpServletRequest request){
        HttpSession session=request.getSession();
        Usuario user=(Usuario) session.getAttribute("userLogado");

        return user;
    }

}
