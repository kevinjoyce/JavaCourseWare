import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUserBasedOnCollection {
	private String phoneNumber;
	private String callTo;
	private ArrayList <HashMap>communicationRecords;
	private LinkedHashMap singleRecord;
	private TreeMap treeMapCallToAndFee;
	private TreeSet callToNumbersSet;
	private ArrayList callToNumbersList;
	public TelcomUserBasedOnCollection(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new ArrayList<HashMap>();
		this.callToNumbersSet = new TreeSet();
		this.callToNumbersList = new ArrayList();
		this.treeMapCallToAndFee = new TreeMap();
	}
	
	//ģ��ͨ����¼������
	void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//������ɵ�i��ͨ����¼			
			//��Calendar��ȡ��ǰʱ��
			Calendar cal = Calendar.getInstance();
			//�����ȥ����Сʱ��10Сʱ���ڣ�
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			//��ö�Ӧ����
			long timeStart = cal.getTimeInMillis();
			//����ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);			
			//���к���
			this.callTo = getCallToPhoneNumber();
			this.callToNumbersList.add(this.callTo);
			this.callToNumbersSet.add(this.callTo);
			//����ͨ����¼
			this.singleRecord = new LinkedHashMap();
			this.singleRecord.put("����", this.phoneNumber);
			this.singleRecord.put("��ʼʱ��", new Date(timeStart));
			this.singleRecord.put("����ʱ��", new Date(timeEnd));
			this.singleRecord.put("���к���", this.callTo);
			this.singleRecord.put("�Ʒ�", this.accountFee(timeStart, timeEnd)+"Ԫ");
			this.communicationRecords.add(this.singleRecord);
			
			this.treeMapCallToAndFee.put(this.callTo, this.accountFee(timeStart, timeEnd));
		}
	}
	
	//������ɱ��к��루����λ�����������
	private String getCallToPhoneNumber() {
		//���һλ�������Ϊ����һЩ�ظ���
		return "1380372000" + String.valueOf(new Random().nextInt(10));
		/*
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
			 */
	}
	
	//ģ��ƷѰ취�����ַ�������ʽ���ر���4λС���ļƷѽ��
	private String accountFee(long timeStart, long timeEnd) {
		//ÿ�����շ�*Ԫ
		double feePerMinute = 0.2;
		//ͨ���������������������
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	void printCallToNumber() {
		for(Object callTo:this.callToNumbersList) {
			System.out.println((String)callTo);
		}
		System.out.println("--------List/Set�ָ���---------");
		for(Object callTo:this.callToNumbersSet) {
			System.out.println((String)callTo);
		}		
	}
	void printCallToAndFee() {
		Iterator it = this.treeMapCallToAndFee.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	//��ӡͨ����¼
	void printDetails() {				
		/*
		 * ʹ��ArrayList�ӿڱ�����ע��Ӧ��communicationRecords����ΪArrayList
		 * ������ӡÿ��ͨ�����ƷѼ�¼��HashMap����
		 */
		
		/*
		 * ʹ��entrySet����ͨ����¼
		 */
		Iterator itRecords = this.communicationRecords.iterator();
		while(itRecords.hasNext()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			this.singleRecord = ((LinkedHashMap)itRecords.next());
			Set entrySet = this.singleRecord.entrySet();
			Iterator itEntry = entrySet.iterator();
			while(itEntry.hasNext()) {
				Map.Entry entry = (Map.Entry)itEntry.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				System.out.println(key + ":" + value);
			}
			
		}
		
		/*
		 * ʹ��keySet����
		Iterator itRecords = this.communicationRecords.iterator();
		while(itRecords.hasNext()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			this.singleRecord = ((HashMap)itRecords.next());
			Set keySet = this.singleRecord.keySet();
			Iterator itKey = keySet.iterator();
			while(itKey.hasNext()) {
				Object key = itKey.next();
				Object value = this.singleRecord.get(key);
				System.out.println(key + ":" + value);
			}
			
		}
		 */
		
		
		/*ʹ��for eachѭ������
		* 
		for(Object aRecord:this.communicationRecords) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String)aRecord).split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			
			//SimpleDateFormat			
			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		}
		*/
		
		
		/*
		 * ʹ��ListIterator�������������
		 * 
		ListIterator it = this.communicationRecords.listIterator(
				this.communicationRecords.size());
		while(it.hasPrevious()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String) it.previous()).split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			
			//SimpleDateFormat			
			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		}
		*/
		
		/*
		 * ʹ�õ�����
		 * 
		Iterator it = this.communicationRecords.iterator();
		while(it.hasNext()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String) it.next()).split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			
			//SimpleDateFormat			
			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		}
		*/
		
		
		/*ʹ������
		//��ȡ��¼��Ŀ����communicationRecords�����е�Ԫ�ظ���
		int arrayListSize = this.communicationRecords.size();
		
		for(int i = 0; i < arrayListSize - 1; i++) {
			System.out.println("---------ͨ����¼�ָ���---------");
			String [] recordField = ((String) this.communicationRecords.get(i)).split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			
			//SimpleDateFormat			
			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		}
		*/
	}
}