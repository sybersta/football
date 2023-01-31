package com.example.football;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.football.Util.DateUtil;
import com.example.football.Util.InsertUtil;
import com.example.football.Util.yzUtils;
import com.example.football.dao.MongoRaceRepository;
import com.example.football.entity.GoalEntity;
import com.example.football.entity.HandicapAnalysisEntity;
import com.example.football.entity.MongoEntity.*;
import com.example.football.mapper.HandicapAnalysisMapper;
import com.example.football.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableMongoRepositories(basePackages = {"com.example.football.*"})
public class FootballApplicationTests {
@Autowired
	HandicapService handicapService;
	@Autowired
	GoalService goalService;
	@Autowired
	BaseMapper baseMapper;
	@Autowired
	MongoService mongoService ;
    @Autowired
    RecommandService recommandService ;
	@Autowired
    MongoTestService mongoTestService;

	String ThreadDate=null;
	@Test
	public void handicapTests() {
		//1 获取第一个进球的时间
//		int total=0;//总场次
//		int winAll=0;//强队赢全
//		int winHalf=0;//强队赢半
//		int loseHalf=0;//强队输半
//		int loseAll=0;//强队输全
//		int bigAll=0;//大球全赢
//		int bigHalf=0;//大球赢半
//		int smallHalf=0;//大球输半
//		int smallAll=0;//大球输全
//		int draw=0;//盘口走水
//		int oddDraw=0;//大小球走水
		//平半盘主队进第一球，先获取进球时间
		List<GoalEntity> goalList = goalService.getFistGoalList(null, null);
		if(goalList!=null&&goalList.size()>0){
			for(GoalEntity goal:goalList){
				HandicapAnalysisEntity entity=null;
				int handicapTabelNumber=goal.getTime();
				int goalLineLTableNumber=goal.getTime();
				if(goal.getTime()!=null&&goal.getRace()!=null) {
					for (int j=0;j<5;j++){
						handicapTabelNumber+=j;
						if(handicapTabelNumber>95){
							break;
						}
						entity = handicapService.hand1("t_handicap_odds_" + handicapTabelNumber,"t_goal_line_odds_" +goalLineLTableNumber, goal.getRace());
						if (entity!=null&&entity.getResult()!=null){
							break;
						}
					}
//					System.out.println("raceId:"+goal.getRace()+"---"+tableNumber+"kkkkkk:"+result);
				}
				if(entity==null){
					continue;
				}
				if(entity.getGoalLineResult()==null){
					for (int j=0;j<5;j++){
						goalLineLTableNumber+=j;
						if(goalLineLTableNumber>95){
							break;
						}
						entity = handicapService.hand1("t_handicap_odds_" + handicapTabelNumber,"t_goal_line_odds_" +goalLineLTableNumber, goal.getRace());
						if (entity!=null&&entity.getGoalLineResult()!=null){
							break;
						}
					}
				}
				if(entity.getResult()==0){
					entity.setMatchResult("走水");
				}else if(entity.getResult()==0.25){
					entity.setMatchResult("主队赢半");
				}else if(entity.getResult()>0.25){
					entity.setMatchResult("主队赢全");
				}else if(entity.getResult()==-0.25){
					entity.setMatchResult("主队输半");
				}else if(entity.getResult()<-0.25){
					entity.setMatchResult("主队输全");
				}
				if(entity.getGoalLineResult()!=null){
					if(entity.getGoalLineResult()==0){
						entity.setMatchGoalLineResult("走水");
					}else if(entity.getGoalLineResult()==0.25){
						entity.setMatchGoalLineResult("大球赢半");
					}else if(entity.getGoalLineResult()>0.25){
						entity.setMatchGoalLineResult("大球赢全");
					}else if(entity.getGoalLineResult()==-0.25){
						entity.setMatchGoalLineResult("大球输半");
					}else if(entity.getGoalLineResult()<-0.25){
						entity.setMatchGoalLineResult("大球输全");
					}
				}
				baseMapper.insert(entity);
				System.out.println("保存成功："+entity.getRace());
			}
		}
		System.out.println("结束啦啦啦");
	}

	@Test
	public void testInsert () throws Throwable {
		//Runner数组，想当于并发多少个。
		List <String> dateList =new ArrayList<String>();

		dateList.add("20210823");
		TestRunnable[] trs = new TestRunnable [dateList.size()];
		for(int i=0;i<dateList.size();i++){
			ThreadDate=dateList.get(i);
			trs[i]=new ThreadA();
		}

		// 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
		// 开发并发执行数组里定义的内容
		mttr.runTestRunnables();
		System.out.println("结束了");
	}

	private class ThreadA extends TestRunnable {
		String firstDate=null;
		Date lastDate=null;
		public ThreadA(){
			firstDate=new String(ThreadDate);
			try {
				lastDate=new SimpleDateFormat("yyyyMMdd").parse("202108026");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void runTest() throws Throwable {
			try {
				Date date= new SimpleDateFormat("yyyyMMdd").parse(firstDate);
				while(date.getTime() <= lastDate.getTime()) {
					try {
						mongoService.ins(date,1);
					} catch (Exception var2) {
						var2.printStackTrace();
					}
					Calendar c1 = Calendar.getInstance();
					c1.setTime(date);
					c1.add(Calendar.DATE, 1);
					date = c1.getTime();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
@Test
	public void addData() throws Exception{
		List<Date> date=new ArrayList<>();
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210801"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210802"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200122"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200223"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200302"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200304"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200801"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200809"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200810"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200816"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200912"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20200920"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20201101"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20201122"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20201128"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210110"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210218"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210310"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210403"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210409"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210412"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210422"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210506"));
	date.add( new SimpleDateFormat("yyyyMMdd").parse("20210714"));
		for(Date d:date){
			mongoService.ins(d,2);
		}
	System.out.println("成功了");
	}
    @Test
    public void recommandData() throws Exception{
	    recommandService.startScann();
    }
	@Test
    public void testSmallBall(){
mongoService.getList();
	}
}

//	private Double handicap;
//
//	private String homeTeamName;
//	private String leagueName;
//	private Integer totalGoal;
//	private String visitingTeamName;
//
//	private Integer homeGoal;
//	private Integer visitingGoal;