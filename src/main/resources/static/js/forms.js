document.addEventListener("DOMContentLoaded", () => {
    const formulario = document.querySelector("form");

    const nome = formulario.querySelector("#name");
    const email = formulario.querySelector("#email");
    const modulo = formulario.querySelector("#module");
    const matricula = formulario.querySelector("#registrationNumber");
    const q1 = formulario.querySelector("#questionOne");
    const q2 = formulario.querySelector("#questionTwo");

    formulario.addEventListener("submit", (event) => {
        event.preventDefault();
        limparValidacoes();

        if (!validarCampos()) return;

        const dados = {
            name: nome.value.trim(),
            email: email.value.trim(),
            registrationNumber: matricula.value.trim(),
            module: modulo.value.trim(),
            questionOne: q1.value.trim(),
            questionTwo: q2.value.trim()
        };

        enviarDados(dados);
    });

    function validarCampos() {
        let valido = true;

        // Validação de resposta 1
        if (q1.value.trim().length < 300) {
            mostrarErro(q1, "A resposta 1 precisa ter pelo menos 300 caracteres.");
            valido = false;
        }

        // Validação de resposta 2
        if (q2.value.trim().length < 150) {
            mostrarErro(q2, "A resposta 2 precisa ter pelo menos 150 caracteres.");
            valido = false;
        }

        return valido;
    }

    function mostrarErro(campo, mensagem) {
        campo.classList.add("is-invalid");

        const erro = document.createElement("div");
        erro.className = "error-message";
        erro.style.color = "#d35400";
        erro.style.fontSize = "14px";
        erro.style.marginTop = "5px";
        erro.textContent = mensagem;

        campo.parentNode.appendChild(erro);
    }

    function limparValidacoes() {
        const erros = formulario.querySelectorAll(".error-message");
        erros.forEach(el => el.remove());

        const inputs = formulario.querySelectorAll("input, textarea");
        inputs.forEach(input => input.classList.remove("is-invalid", "is-valid"));
    }

    function enviarDados(dados) {
        fetch("http://localhost:8080/api/activities/v1/response", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(dados)
        })
        .then(response => {
            if (!response.ok) throw new Error("Erro na resposta do servidor");
            return response.json();
        })
        .then(data => {
            console.log("Success:", data);
            alert("Respostas enviadas com sucesso!");
            resetForm();
        })
        .catch(error => {
            console.error("Error:", error);
            alert("Erro ao enviar respostas. Tente novamente.");
        });
    }

    function resetForm() {
        formulario.reset();
        limparValidacoes();
        setTimeout(() => email.focus(), 100);
        console.log("Formulário resetado com sucesso");
    }
});
