const formulario = document.querySelector('form');

// Selecionando os elementos corretos do formulário
const matricula = formulario.querySelector('#registrationNumber');
const senha = formulario.querySelector('#password');

formulario.addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio padrão do formulário
    login();
});

function login() {
    const valorMatricula = matricula.value.trim();
    const valorSenha = senha.value.trim();

    // Validação básica
    if (!valorMatricula) {
        alert('Por favor, preencha a matrícula.');
        matricula.focus();
        return;
    }

    if (!valorSenha) {
        alert('Por favor, preencha a senha.');
        senha.focus();
        return;
    }

    console.log('Matrícula:', valorMatricula);
    console.log('Senha:', valorSenha);

    // Exemplo básico de requisição POST para backend (ajuste URL conforme seu projeto)
    fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify({
            registrationNumber: valorMatricula,
            password: valorSenha
        })
    })
    .then(response => {
        if (!response.ok) {
            // Pode personalizar o erro baseado no status
            throw new Error('Credenciais inválidas ou erro no servidor');
        }
        return response.json();
    })
    .then(data => {
        console.log('Login bem sucedido:', data);
        alert('Login efetuado com sucesso!');

        // Redirecionar ou atualizar a página, por exemplo:
        // window.location.href = '/dashboard';
    })
    .catch(error => {
        console.error('Erro no login:', error);
        alert('Falha no login: ' + error.message);
    });
}
