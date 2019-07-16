import java.util.List;

@Mapper
public interface ${className?cap_first}DaoC {
	
	public List<${className?cap_first}Bean> get${className?cap_first}s(${className?cap_first}Bean ${className}Bean,PageBean pageBean);
	
	public int update${className?cap_first}(${className?cap_first}Bean ${className}Bean);
	
	public int delete${className?cap_first}(${className?cap_first}Bean ${className}Bean);
	
	public int insert${className?cap_first}(${className?cap_first}Bean ${className}Bean);
	
	public ${className?cap_first}Bean get${className?cap_first}(${className?cap_first}Bean ${className}Bean);

}

