package com.sunjun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunjun.dao.BorderDao;
import com.sunjun.dao.StatusDao;
import com.sunjun.dao.impl.BorderDaoImpl;
import com.sunjun.dao.impl.StatusDaoImpl;
import com.sunjun.domain.Border;
import com.sunjun.domain.Status;
import com.sunjun.util.WriteDataUtil;

public class InitListener implements ServletContextListener {
	

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		BorderDao borderDao = new BorderDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		final File file = new File("D:\\xmlbackup");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
				
					
					new WatchDir(file, true, new FileActionCallback() {
						@Override
						public void create(File file) {

							try {
								System.out.println("创建文件 \t" + file.getAbsolutePath());
								Border border = new Border();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Thread.sleep(300);
								SAXReader reader = new SAXReader();
								Document document = reader.read(new File(file.getAbsolutePath()));
								Element root = document.getRootElement();
								Attribute testStatusAttr2 = root.attribute("testStatus");
								if(testStatusAttr2.getText().contains("Passed")) {
									Element contactElem2 = root.element("BoardXML");
									Attribute serialNumberAttr2 = contactElem2.attribute("serialNumber");
									Element stationXML2 = root.element("StationXML");
									Attribute testerNameAttr2 = stationXML2.attribute("testerName");
									if(testerNameAttr2.getText().equals("V810-8057S2")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"L22");
									}
									if(testerNameAttr2.getText().equals("V810-8064S2")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"L12");
									}
									if(testerNameAttr2.getText().equals("V810-8070S2")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"K22");
									}
									if(testerNameAttr2.getText().equals("V810-8085S2")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"K12");
									}
									if(testerNameAttr2.getText().equals("V810-8096S2")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"J12");
									}
									if(testerNameAttr2.getText().equals("V810-3327S2EX")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"I12");
									}
									if(testerNameAttr2.getText().equals("V810-3323S2EX")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"I22");
									}
									if(testerNameAttr2.getText().equals("V810-3328S2EX")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"H12");
									}
									if(testerNameAttr2.getText().equals("V810-8086S2")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"P12");
									}
									if(testerNameAttr2.getText().equals("V810-3325S2EX")) {
										 WriteDataUtil.writeSn(serialNumberAttr2.getText(),"Q12");
									}
									return;
								}
								Attribute testTimeAttr = root.attribute("testTime");
								String testTime = testTimeAttr.getText();
								DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
								if(testTimeAttr.getText().length()>20) {
									//说明是 复杂的时间格式
									Date date = df.parse(testTimeAttr.getText());
									SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
									Date date1 = df1.parse(date.toString());
									DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String value = df2.format(date1);
									border.setTestTime(sdf.parse(value));
								}else {
									//是简单的时间格式
									border.setTestTime(sdf.parse(testTimeAttr.getText()));
								}
								
								Attribute testStatusAttr = root.attribute("testStatus");
								border.setTestStatus(testStatusAttr.getText());
								Element contactElem = root.element("BoardXML");
								Attribute serialNumberAttr = contactElem.attribute("serialNumber");
								border.setSerialNumber(serialNumberAttr.getText());
								Attribute boardTypeAttr = contactElem.attribute("boardType");
								border.setBoardType(boardTypeAttr.getText());
								Element stationXML = root.element("StationXML");
								Attribute testerNameAttr = stationXML.attribute("testerName");
								border.setTesterName(testerNameAttr.getText());

								Border boder = borderDao.findBorderByserialNumbers(serialNumberAttr.getText());

								if (boder == null) {
									int add = borderDao.adds(border);
									System.out.println(add);

								} else {
									System.out.println("已经添加过");
								}
								
								List<Element> eleList = root.elements();
								
								
								List<Status> listStaus = new ArrayList<Status>();
								for(Element eles:eleList) {
									Status status =null;
									if(eles.getName().equals("TestXML")) {
										status = new Status();
										Element inElement = eles.element("IndictmentXML");
										status.setErrCode(inElement.attributeValue("indictmentType"));
										status.setSerialNumber(serialNumberAttr.getText());
									    status.setImageFilename(inElement.attributeValue("imageFileName"));
										status.setAlgorithm(inElement.attributeValue("algorithm"));
										status.setSubType(inElement.attributeValue("subType"));
									    List<Element> childList = inElement.elements();
										for(Element demo:childList) {
											if(demo.getName().equals("ComponentXML")) {
												Attribute attributedesignator = demo.attribute("designator");
												if(!"".equals(demo.attribute("pin").getValue())) {
													status.setPin(demo.attribute("pin").getValue().trim());
												}
												status.setLocation(attributedesignator.getValue());
											}
											if(demo.getName().equals("RepairActionXML")) {
												Attribute attributerepairStatus = demo.attribute("repairStatus");
												status.setRepairStatus(attributerepairStatus.getValue());
											}
										}
									}
						          if(status !=null) {
						        	  listStaus.add(status);
						          }
								}
								
								
								
								
								
								int batchInsert = statusDao.batchInsert(listStaus);
								System.out.println("fail count " + batchInsert);
								
								
								
								
								
								
								
								
								
								
								

							} catch (DocumentException e) {
								e.printStackTrace();
							} catch (ParseException e) {
								e.printStackTrace();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("开启文件监控系统:" + file.getAbsolutePath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
