
@Service
@Transactional(rollbackFor=Exception.class)
public class ${className?cap_first}ServiceC  implements I${className?cap_first}ServiceC{
	@Autowired
	${className?cap_first}DaoC ${className}DaoC;

	@Override
	public Object get${className?cap_first}s(${className?cap_first}Bean ${className}Bean, PageBean pageBean) {
		List<${className?cap_first}Bean> ${className}Beans = ${className}DaoC.get${className?cap_first}s(${className}Bean, pageBean);
		return pageBean.setObject(${className}Beans);
	}

	@Override
	public Object get${className?cap_first}(${className?cap_first}Bean ${className}Bean) {
		return ${className}DaoC.get${className?cap_first}(${className}Bean);
	}

	@Override
	public Object update${className?cap_first}(${className?cap_first}Bean ${className}Bean) {
		int num = ${className}DaoC.update${className?cap_first}(${className}Bean);
		if(num <= 0){
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object insert${className?cap_first}(${className?cap_first}Bean ${className}Bean) {
		int num = ${className}DaoC.insert${className?cap_first}(${className}Bean);
		if(num <= 0){
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object delete${className?cap_first}(${className?cap_first}Bean ${className}Bean) {
		int num = ${className}DaoC.delete${className?cap_first}(${className}Bean);
		if(num <= 0){
			throw new AppException("失败");
		}
		return num;
	}


}