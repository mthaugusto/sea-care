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
