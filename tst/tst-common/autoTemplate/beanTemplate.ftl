
public class ${className?cap_first}Bean implements Serializable {

	<#list columnMap?keys as key>
		private String ${key};
	</#list>


	<#list columnMap?keys as key>
	
		public String get${key?cap_first}() {
				return ${key};
        }
		public ${className?cap_first}Bean set${key?cap_first}(String ${key}) {
				this.${key} = ${key};
		        return this;
        }
	</#list>

}
