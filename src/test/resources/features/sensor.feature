Feature: Teste de sensores via API REST

  Scenario: Criar um sensor com sucesso
    Given a payload válido de sensor
    When enviar uma requisição POST para "/sensores"
    Then a resposta deve ter status 201
    And o corpo deve conter o tipo "temperatura"

  Scenario: Buscar todos os sensores
    When enviar uma requisição GET para "/sensores"
    Then a resposta deve ter status 200
    And o corpo deve estar em conformidade com o JSON Schema

  Scenario: Criar um sensor inválido
    Given um payload inválido de sensor
    When enviar uma requisição POST para "/sensores"
    Then a resposta deve ter status 400
