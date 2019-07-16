
@Controller
@RequestMapping("/${className}Controller/v1.0")
public class ${className?cap_first}Controller {
	@Autowired
	I${className?cap_first}ServiceC ${className}ServiceC;

	@RequestMapping("/get${className?cap_first}s")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object get${className?cap_first}s(${className?cap_first}Bean ${className}Bean, PageBean pageBean)throws Exception{
		return ${className}ServiceC.get${className?cap_first}s(${className}Bean, pageBean);
	}	
	@RequestMapping("/update${className?cap_first}")
	@AppController(isVerSystemToken=true)
	public Object update${className?cap_first}(${className?cap_first}Bean ${className}Bean)throws Exception{
		return ${className}ServiceC.update${className?cap_first}(${className}Bean);
	}	
	@RequestMapping("/get${className?cap_first}")
	@AppController(isVerSystemToken=true)
	public Object get${className?cap_first}(${className?cap_first}Bean ${className}Bean)throws Exception{
		return ${className}ServiceC.get${className?cap_first}(${className}Bean);
	}
	@RequestMapping("/delete${className?cap_first}") 
    @AppController(isVerSystemToken=true)
    public Object delete${className?cap_first}(${className?cap_first}Bean ${className}Bean) throws Exception{ 
		return ${className}ServiceC.delete${className?cap_first}(${className}Bean);
	}
	
	@RequestMapping("/insert${className?cap_first}") 
    @AppController(isVerSystemToken=true)
	public Object insert${className?cap_first}(${className?cap_first}Bean ${className}Bean) throws Exception{ 
		
		return ${className}ServiceC.insert${className?cap_first}(${className}Bean);
	}
	
	
}
