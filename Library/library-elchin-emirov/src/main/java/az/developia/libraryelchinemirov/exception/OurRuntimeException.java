package az.developia.libraryelchinemirov.exception;

import org.springframework.validation.BindingResult;

public class OurRuntimeException extends RuntimeException{
		private BindingResult br;
		public OurRuntimeException(String m, BindingResult br) {
			super(m);
			this.br=br;
		}
		public OurRuntimeException(String string) {
			// TODO Auto-generated constructor stub
		}
		public BindingResult getBr() {
			return br;
		}
		}