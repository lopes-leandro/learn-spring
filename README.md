Simple project to learning Spring Framework


#  Tratamento de Exceções de Tempo de Execução

* IndexOutOfBoundsException: essa exceção ocorre quando acessamos um índice de um array de string ou interável está fora do intervalo;
* IllegalArgumentException: essa exceção ocorre quando um método foi passado por um argumento ilegal;
* NullPointerException: esse exceção ocorre quando uma variável é acessada não aponta para nenhum objeto ou nulo;

# Criando Controladores no Spring Framework

* __@RestController__ : é uma forma especializada da anotação __@Controller__, ele já inclui a anotação __@Controller__ e __@ResponseBody__, não sendo necessário especificar a anotação __@ResponseBody__ em cada método.

* __@RequestMapping__ : é uma anotação usada para mapear as solicitações do HyperText Transfer Protocol (HTTP) aos métodos dos controladores Representational State Transfer (REST). É também onde definimos um caminho base para o controlador.

* __@GetMapping__ : mapeia solicitações __HTTP GET__ em um método; a anotação é um atalho para __@RequestMapping(method = RequestMethod.GET)__

* __@PutMapping__ : mapeia solicitações __HTTP PUT__ em um método; a anotação é um atalho para __@RequestMapping(method = RequestMethod.PUT)__

* __@PostMapping__ : mapeia solicitações __HTTP POST__ em um método; a anotação é um atalho para __@RequestMapping(method = RequestMethod.POST)__

* __@DeleteMapping__ : mapeia solicitações __HTTP DELETE__ em um método; a anotação é um atalho para __@RequestMapping(method = RequestMethod.DELETE)__ 

* __@PathVariable__ : essa anotação é usada para obter o valor dos parâmetros do terminal

* __@Valid__ : essa anotação é usada para verificar a validade de um objeto; é comumente usado no corpo da solicitação para verificar se uma solicitação passada é um objeto válido;