package App;

import Class.Admin;
import Class.Cliente;
import Class.Estoque;
import Class.Funcionario;
import Class.Ingredintes;
import Class.Item;
import Class.Pedido;
import Services.AdminService;
import Services.ClienteService;
import Services.EstoqueService;
import Services.FuncionarioService;
import Services.PedidoService;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        FuncionarioService funcionarioService = new FuncionarioService();

        AdminService adminService = new AdminService();

        Cliente cliente1 = new Cliente("Igor Nascimento", "(86) 99415-1721", "igornalves901@gmail.com",
                "Silvania goias", 0);
        Cliente cliente2 = new Cliente("Yasmin Nascimento", "(86) 99415-1721", "Yasmin201@gmail.com", "Silvania goias",
                0);
        Cliente cliente3 = new Cliente("Ivone Alves", "(86) 99415-1721", "ivone 09832@gmail.com", "Silvania goias", 0);
        
        
        Funcionario funcionario = new Funcionario("Fernanda", "recursos humanos", 1500, 8);
        Funcionario funcionario2 = new Funcionario("Matheus", "estoque", 2500, 8);
        Funcionario funcionario3 = new Funcionario("carlos", "vendas", 1200, 8);

        List<Ingredintes> listaParaConsumo = new ArrayList<>();
        
        Estoque estoque = new Estoque(listaParaConsumo, 30);
        EstoqueService estoqueService = new EstoqueService(estoque);
        
        ClienteService clienteService = new ClienteService(cliente2);
        
        Admin gerenteGarcons = new Admin("Lucas", "gerencia", 3000, 6);
        Admin gerenteEscritorio = new Admin("Nicola", "gerencia", 2400, 6);
        Admin gerenteVendas = new Admin("Larissa", "gerencia", 1400, 8);
        
        Ingredintes ingredintes = new Ingredintes("Tomates", 10);
        Ingredintes ingredintes2 = new Ingredintes("cenoura", 10);
        Ingredintes ingredintes3 = new Ingredintes("Trigo", 10);
        Ingredintes ingredintes4 = new Ingredintes("repolho", 5);
        
        System.out.println();
        listaParaConsumo.add(ingredintes);
        listaParaConsumo.add(ingredintes2);
        listaParaConsumo.add(ingredintes3);
        listaParaConsumo.add(ingredintes4);

        estoqueService.alertarBaixa();
        System.out.println();
        estoqueService.ListandoTodosOsIngredientes();
        System.out.println();
        estoqueService.removendoEstoque(ingredintes3);
        System.out.println();
        estoqueService.ListandoTodosOsIngredientes();
        System.out.println();

        adminService.registrarAdmin(gerenteGarcons);
        System.out.println();
        adminService.registrarAdmin(gerenteEscritorio);
        System.out.println();
        adminService.registrarAdmin(gerenteVendas);
        System.out.println();
        
        adminService.listandoAdmins();
        System.out.println();
        
        adminService.removerAdmin(gerenteEscritorio);
        System.out.println();
        
        adminService.listandoAdmins();
        System.out.println();
        
        funcionarioService.registrarFuncionario(funcionario2);
        funcionarioService.registrarFuncionario(funcionario);
        funcionarioService.registrarFuncionario(funcionario3);
        System.out.println();
        
        funcionarioService.listandoFuncionario();
        System.out.println();
        
        funcionarioService.removerFuncionario(funcionario3);
        System.out.println();

        funcionarioService.listandoFuncionario();
        System.out.println();

        funcionarioService.logar("Matheus");
        System.out.println();
        
        funcionarioService.atenderCliente(funcionario3, cliente1);
        System.out.println();

        funcionarioService.atenderCliente(funcionario, cliente2);
        System.out.println();

        Item item1 = new Item("Hamburger", 22.99);
        Item item2 = new Item("refrigerante", 5.99);
        
        Item item3 = new Item("pizza", 50.89);
        Item item4 = new Item("guarana", 14.50);
        
        Pedido pedido = new Pedido("1", cliente1, funcionario3, true);
        Pedido pedido2 = new Pedido("2", cliente2, funcionario, true);
        Pedido pedido3 = new Pedido("3", cliente3, funcionario2, false);
        
        PedidoService pedidoService = new PedidoService(pedido);
        PedidoService pedidoService2 = new PedidoService(pedido2);
        PedidoService pedidoService3 = new PedidoService(pedido3);

        funcionarioService.registrarPedido(pedido2);
        funcionarioService.registrarPedido(pedido);
        funcionarioService.registrarPedido(pedido3);
        System.out.println();

        pedidoService.adicionarItem(item1);
        pedidoService.adicionarItem(item2);

        pedidoService2.adicionarItem(item1);
        pedidoService2.adicionarItem(item2);

        pedidoService3.adicionarItem(item4);
        pedidoService3.adicionarItem(item3);

        funcionarioService.gerarRelatoriosVendas(funcionario3);
        System.out.println();

        funcionarioService.gerarRelatoriosVendas(funcionario);
        System.out.println();

        funcionarioService.contaParaCliente(pedido2, pedidoService3);
        funcionarioService.contaParaCliente(pedido2, pedidoService2);


        clienteService.pagarConta(pedido3, "Pix");
        System.out.println();

    }
}
