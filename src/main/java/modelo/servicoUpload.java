package modelo;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class servicoUpload {
	private String diretorio;
	private String nomeArq;
	private String extensoes;
	private int tamMax;
	
	private static int MB = 1024 * 1024;
	private static int KB = 1024;
	
	private String nomeOriginal;
	private File arqTemp = null;
	
	private String erro = null;

	public servicoUpload(String diretorio, String extensoes, int tamMax) {
		super();
		this.diretorio = diretorio;
		this.extensoes = extensoes;
		this.tamMax = tamMax;
	}
	
	public boolean fazUpload(HttpServletRequest request, ServletContext context, FileItem arqItem) {
		if (request.getContentType() == null)
			return false;
		
		try {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4 * KB);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(tamMax * MB);
			
			String caminhoDiretorio = context.getRealPath("") + File.separator + diretorio;
	
			File diretorioUpload = new File(caminhoDiretorio);
			
			if (!diretorioUpload.exists()) {
				diretorioUpload.mkdir();
			}
			
			FileItem arq = arqItem;
			
			String nomeArquivo = new File(arq.getName()).getName();
			
			if(!verificaArq(nomeArquivo)) {
				setErro("Arquivo com Formato não Permitido");
				return false;
			}
			
			String caminhoArquivo = caminhoDiretorio + File.separator + nomeArquivo;
			File arquivo = new File(caminhoArquivo);
			
			if (arquivo.exists()) {
				nomeOriginal = arquivo.getName();
				arqTemp = new File(caminhoDiretorio + File.separator + "temp" + nomeOriginal);
				if(arqTemp.exists()) {
					arqTemp.delete();
				}
				arquivo.renameTo(arqTemp);
				arquivo = new File(caminhoArquivo);
			}
			
			arq.write(arquivo);
			this.nomeArq = diretorio + File.separator + arquivo.getName();
			if(arqTemp != null) {
				arqTemp.deleteOnExit();
			}
			
			
		} catch (FileUploadBase.SizeLimitExceededException e) {
			setErro("Tamanho de arquivo excedido");
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			if (arqTemp != null) {
				File arquivoOriginal = new File(context.getRealPath("") + File.separator + diretorio + File.separator + nomeOriginal);
				arqTemp.renameTo(arquivoOriginal);
				arqTemp = null;
			}
			setErro("Ocorreu um Erro no Upload do Arquivo: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean verificaArq(String nomeArquivo) {
		String nome = nomeArquivo.toLowerCase();
		
		String[] exts = extensoes.split(", ");
		for(int i = 0; i < exts.length; i++) {
			if(nome.endsWith("." + exts[i].trim())){
				return true;
			}
		}
		return false;
	}

	public String getNomeArq() {
		return nomeArq;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
}
