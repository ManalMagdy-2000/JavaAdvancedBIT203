package a1;
public class Document {
	private String documentID;
	private String filename;
	private String description;
	public Document(String documentID, String filename, String description) {
		super();
		setDocumentID(documentID);
		setFilename(filename);
		setDescription(description);
		
	}
	public Document(String filename, String description) {
		super();
		this.filename = filename;
		this.description = description;
	}

	public String getDocumentID() {
		return documentID;
	}
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Document [getDocumentID()=" + getDocumentID() + ", getFilename()=" + getFilename()
				+ ", getDescription()=" + getDescription() + "]";
	}

	
	
}
