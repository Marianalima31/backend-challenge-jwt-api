# BACKEND CHALLENGE 

Este é um exemplo de API que recebe por parametros um JWT (string) e verifica se é valida conforme regras abaixo:

- Deve ser um JWT válido
- Deve conter apenas 3 claims (Name, Role e Seed)
- A claim Name não pode ter carácter de números
- A claim Role deve conter apenas 1 dos três valores (Admin, Member e External)
- A claim Seed deve ser um número primo.
- O tamanho máximo da claim Name é de 256 caracteres.

## O que são tokens da Web JSON?

O JSON Web Token (JWT) é um padrão aberto (RFC 7519) que define uma maneira compacta e independente de transmitir informações com segurança entre as partes como um objeto JSON. Essas informações podem ser verificadas e confiáveis ​​porque são assinadas digitalmente. Os JWTs podem ser assinados usando um segredo (com o algoritmo HMAC) ou um par de chaves pública/privada usando RSA ou ECDSA.

Os JSON Web Tokens consistem em três partes, separadas por .' s:

- Cabeçalho
- Carga útil
- Assinatura
- Um JWT tem, portanto, a seguinte estrutura: xxxxx.yyyyy.zzzzz

## Características

- Criando tokens da Web JSON
- Opções poderosas de validação de JWT
- API autoexplicativa e fácil de aprender
- Interfaces fluentes

## Validando JWTs

Validação básica

