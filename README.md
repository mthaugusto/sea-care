<h1>Sea Care</h1>

<h2>Integrantes</h2>

<ul>
    <li><strong>Matheus Augusto Leite</strong> - RM99697</li>
    <li><strong>André Sant'Ana Boim</strong> - RM551575</li>
    <li><strong>Marcelo Hespanhol Dias</strong> - RM98251</li>
    <li><strong>Gustavo Imparato Chaves</strong> - RM551988</li>
    <li><strong>Gabriel Eringer de Oliveira</strong> - RM99632</li>
</ul>


<h2>Como Rodar a Aplicação</h2>

<ol>
    <li><strong>Pré-requisitos:</strong> Certifique-se de ter instalado o Java JDK 11 ou superior e um banco de dados compatível com a aplicação.</li>
    <li>Clone o repositório para sua máquina local usando o comando:
        <pre><code>git clone https://github.com/mthaugusto/sea-care</code></pre>
    </li>
    <li>Acesse o diretório do projeto:
        <pre><code>cd sea-care</code></pre>
    </li>
    <li>Configure as variáveis de ambiente ou arquivos de configuração conforme necessário para seu ambiente de desenvolvimento.</li>
    <li>Compile e execute a aplicação:
        <pre><code>mvn spring-boot:run</code></pre>
    </li>
</ol>

<h2>Importar Testes no Postman</h2>
<p>Para importar testes no Postman, siga estas etapas:</p>

<ol>
    <li><strong>Abra o Postman:</strong> Inicie o aplicativo Postman no seu computador.</li>
    <li><strong>Vá para a aba "Collections":</strong> No painel esquerdo, encontre e clique em "Collections" para ver as coleções existentes.</li>
    <li><strong>Inicie o processo de importação:</strong> Na parte superior do painel "Collections", clique no botão "Import".</li>
    <li><strong>Selecione o arquivo:</strong> Clique em "Upload Files" para selecionar o arquivo de teste que você deseja importar. Certifique-se de que o arquivo esteja em um formato compatível, como JSON ou coleção Postman.</li>
    <li><strong>Complete a importação:</strong> Depois de selecionar o arquivo, clique em "Import" para iniciar a importação.</li>
    <li><strong>Verifique as coleções:</strong> Após a importação, suas coleções de testes estarão disponíveis na aba "Collections" à esquerda. Você pode agora visualizar e executar os testes importados.</li>
</ol>

<h2>Swagger</h2>
<p>Para testar a API, você pode utilizar o Swagger, que oferece uma interface gráfica para interagir com os endpoints da aplicação. Siga os passos abaixo para acessar o Swagger:</p>

<ol>
    <li>Certifique-se de que a aplicação está em execução localmente.</li>
    <li>Abra um navegador da web e acesse o seguinte URL: <code>http://localhost/swagger-ui.html</code>.</li>
    <li>A página do Swagger será exibida, mostrando todos os endpoints disponíveis na API.</li>
    <li>Você pode clicar em cada endpoint para expandir e ver detalhes sobre os parâmetros necessários e o formato das respostas.</li>
    <li>Para fazer uma solicitação, clique no endpoint desejado e depois no botão "Try it out". Preencha os parâmetros necessários e clique em "Execute" para ver a resposta da API.</li>
</ol>

<img src="https://github.com/mthaugusto/sea-care/blob/master/documentacao/swagger-print.png" alt="Swagger Print 1">
<img src="https://github.com/mthaugusto/sea-care/blob/master/documentacao/swagger2-print.png" alt="Swagger Print 2">

<h2>Documentação da API</h2>
<h3>Categorias</h3>
<ul>
    <li><strong>GET /categorias</strong>: Retorna uma lista de todas as categorias.</li>
    <li><strong>GET /categorias/{id}</strong>: Retorna uma categoria específica pelo ID.</li>
    <li><strong>POST /categorias</strong>: Cria uma nova categoria com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
  "nomeCategoria": "Eletronicos"
}</code></pre>
        </li>
    </ul>
</ul>
<h3>Fornecedores</h3>
<ul>
    <li><strong>GET /fornecedores</strong>: Retorna uma lista de todos os fornecedores.</li>
    <li><strong>GET /fornecedores/{id}</strong>: Retorna um fornecedor específico pelo ID.</li>
    <li><strong>POST /fornecedores</strong>: Cria um novo fornecedor com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
	"id": 1,
	"nomeFornecedor": "Camisetas & Malhas",
	"cnpj": "00.000.000/0001-00",
	"telefone": "11999999999",
	"setor": "Roupas"
}</code></pre>
        </li>
    </ul>
</ul>
<h3>Produtos</h3>
<ul>
    <li><strong>GET /produtos</strong>: Retorna uma lista de todos os produtos.</li>
    <li><strong>GET /produtos/{id}</strong>: Retorna um produto específico pelo ID.</li>
    <li><strong>POST /produtos</strong>: Cria um novo produto com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
    "nomeProduto": "Camiseta SeaCare",
    "valorProduto": "29.90",
    "linkProduto": "http://marketplace.com/camiseta",
    "fornecedorId": 1,
    "categoriaId": 1
}</code></pre>
        </li>
    </ul>
</ul>
<h3>Usuários</h3>
<ul>
    <li><strong>GET /usuarios</strong>: Retorna uma lista de todos os usuários.</li>
    <li><strong>GET /usuarios/{id}</strong>: Retorna um usuário específico pelo ID.</li>
    <li><strong>POST /usuarios</strong>: Cria um novo usuário com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
    "nomeUsuario": "Roberto Costa",
    "nivelPermissao": 1,
    "cpf": "321.654.987-30",
    "login": "robertocosta",
    "senha": "senha123",
    "cep": "56789-012",
    "email": "roberto.costa@example.com",
    "telefone": "519876-5432"
}</code></pre>
        </li>
    </ul>
</ul>
<h3>Relatos</h3>
<ul>
    <li><strong>GET /relatos</strong>: Retorna uma lista de todos os relatos.</li>
    <li><strong>GET /relatos/{id}</strong>: Retorna um relato específico pelo ID.</li>
    <li><strong>POST /relatos</strong>: Cria um novo relato com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
    "nomeRelato": "Sujeira na praia de Santos",
    "descricaoRelato": "Na praia de Santos, a maré baixa acabou revelando grande quantidade de lixo no mar conforme foto. Seria interessante marcarmos uma ação coletiva par aa limpeza e conscientização",
    "linkFoto": "http://foto/1",
    "usuarioId": 1
}</code></pre>
        </li>
    </ul>
</ul>
<h3>Parceiros</h3>
<ul>
    <li><strong>GET /parceiros</strong>: Retorna uma lista de todos os parceiros.</li>
    <li><strong>GET /parceiros/{id}</strong>: Retorna um parceiro específico pelo ID.</li>
    <li><strong>POST /parceiros</strong>: Cria um novo parceiro com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
    "nomeParceiro": "RennerSF",
    "cnpj": "00.000.000/0001-00",
    "telefone": "11999999999",
    "email": "contato@rennersf.com.br",
    "setor": "Roupas",
    "status": 1,
    "dt_inicio": "2024-06-01"
}</code></pre>
        </li>
    </ul>
</ul>
<h3>Eventos</h3>
<ul>
    <li><strong>GET /eventos</strong>: Retorna uma lista de todos os eventos.</li>
    <li><strong>GET /eventos/{id}</strong>: Retorna um evento específico pelo ID.</li>
    <li><strong>POST /eventos</strong>: Cria um novo evento com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
    "nomeEvento": "Palestra Oceano Azul",
    "dataEvento": "2024-06-01",
    "tipoEvento": "Palestra",
    "descricaoEvento": "Palestra sobre sustentabilidade dos oceanos com ninguém mais nem menos que: Bene",
    "foto": "http://foto.link.com.br",
    "local": "Av. Paulista - 1106 - 7º andar - São PauloSP",
    "nrParticipantes": 100,
    "parceirosIds": [1, 2]
}</code></pre>
        </li>
    </ul>
</ul>
<h3>Inscrições</h3>
<ul>
    <li><strong>GET /inscricoes</strong>: Retorna uma lista de todas as inscrições.</li>
    <li><strong>GET /inscricoes/{id}</strong>: Retorna uma inscrição específica pelo ID.</li>
    <li><strong>POST /inscricoes</strong>: Cria uma nova inscrição com os dados fornecidos.</li>
    <ul>
        <li>Corpo da requisição (JSON):
            <pre><code>{
    "eventoId": 1,
    "usuarioId": 1,
    "dataInscricao": "2024-06-06"
}</code></pre>
        </li>
    </ul>
</ul>

<p>Para informações mais detalhadas sobre os endpoints, consulte a documentação de código ou use ferramentas de API como Postman para explorar a API.</p>
