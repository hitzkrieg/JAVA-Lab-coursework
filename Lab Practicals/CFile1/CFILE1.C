#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
	int empId;
	char name[20];
	char deptName[20];
	char skills[20];
	double salary;

} employee;

/*Function declarations.*/

void initialize();
char* substring(char* Str, int n);
char* lowercase(char* ch);
void commandInterpretor();
void printRecord(int n);
void insert(int EmpId, char Name[20], char DeptName[20], char Skills[20], double Salary);
void updateFile();
void deleteRecord(int i);
void update(int k, char tmpa[5][2][30], int i);

employee employees[100];
int i, num; char sub[50];


void initialize()
{

	FILE *ifp= fopen("Employee.txt", "r");

	if (ifp == NULL) {
		printf("Couldn't open file!");
		exit(1);
	}

	fscanf(ifp, "%d", &num);
	for(i=0; i<num; i++)
	{
		fscanf(ifp, "%d %s %s %s %lf ", &employees[i].empId, employees[i].name, employees[i].deptName, employees[i].skills, &employees[i].salary);
	}
	fclose(ifp);


}

char* substring(char* Str, int n)
{
	
	for(i=0; i<n; i++)
	{
		sub[i]=*Str;
		Str++;
	}
	sub[n]='\0';
	return(sub);
}

char* lowercase(char* ch)
{
	i=0;
	
	while(*ch!='\0')
	{
		if((*ch>='A')&&(*ch<='Z'))
		sub[i]= *ch -('A'-'a');
		i++;
	}
	return(sub);
}
void commandInterpretor()
{
	char tmp1[30], tmp2[30];
	char* tmp;
	double Salary;
	int flag, k, EmpId;
	char tmpa[30], tmpb[30], tmpc[30], tmpd[30], tmpe[30];
	char tempa[5][2][30];

	char command1[30], command[30];
	gets(command1);
	strcpy(command,lowercase(command1));

	if(strcmp(command,"select *")==0) /* to check select* */
	{
		for(i=0; i<num; i++)
		{
			printRecord(i);
		}
		commandInterpretor();
	}

	else if(strcmp(substring(command, strlen("select * from employee where salary > ")), "select * from employee where salary > ")==0) /*to check select * where salary > */
	{

		tmp=command;
		for(i=0; i<strlen("select * from employee where salary > "); i++)
		{
			tmp++;
		}
		i=0;
		while(*tmp!='\0')
		{

			tmp2[i]=*tmp; /* tmp2 stores the minimum salary */
			tmp++;
			i++;
		}

		Salary=atof(tmp2);
		flag=0;

		for(i=0; i<num; i++)
		{
			if(employees[i].salary>Salary)
			{
				flag=1;
				printRecord(i);
			}
		}
		if(flag==0)
		printf("No record.");
		commandInterpretor();
	}


	else if(strcmp(substring(command, strlen("select * from employee where")), "select * from employee where")==0)
	/* to check Select * from Employee where <Field>=<User input value> */
	{
		tmp=command;
		for(i=0; i<strlen("select * from employee where "); i++)
		{
			tmp++;
		}
		i=0;
		while(*tmp!='=')
		{

			tmp1[i]=*tmp; /* tmp1 stores field */
			tmp++;
			i++;
		}
		tmp++;i=0;
		while(*tmp!='\0')
		{
			tmp2[i]= *tmp; /* tmp2 stores the user input value as string */
			tmp++;
		}

		if(strcmp(tmp1, "empid")==0)
		{
			int id, flag=0;
			id= atoi(tmp2);
			for(i=0; i<num; i++)
			{
				if(employees[i].empId==id)
				{
					flag=1;
					printRecord(i);

				}
			}
			if(flag==0)
			printf("\n No record.");

		}

		else if(strcmp(tmp1, "name")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].name),tmp2)==0)
				{
					flag=1;
					printRecord(i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}
		else if(strcmp(tmp1, "dept name")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].deptName),tmp2)==0)
				{
					flag=1;
					printRecord(i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}
		else if(strcmp(tmp1, "skills")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].skills),tmp2)==0)
				{
					flag=1;
					printRecord(i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}

		else if(strcmp(tmp1, "salary")==0)
		{
			double Salary; int flag=0;
			Salary= atof(tmp2);
			for(i=0; i<num; i++)
			{
				if(employees[i].salary==Salary)
				{
					flag=1;
					printRecord(i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}
		commandInterpretor();
	}

	else if(strcmp(substring(command, strlen("insert into employee values")), "insert into employee values")==0)
	/* to check if user wants to insert a new record */
	{
		tmp=command1;


		for(i=0; i<strlen("insert into employee values("); i++)
		{
			tmp++;
		}
		i=0;
		while(*tmp!=',')
		{

			tmpa[i]=*tmp; /* tmpa stores empid */
			tmp++;
			i++;
		}

		tmp++;
		i=0;

		while(*tmp!=',')
		{

			tmpb[i]=*tmp; /* tmpb stores name */
			tmp++;
			i++;
		}
		tmp++;
		i=0;

		while(*tmp!=',')
		{

			tmpc[i]=*tmp; /* tmpc stores dept name */
			tmp++;
			i++;
		}
		tmp++;
		i=0;

		while(*tmp!=',')
		{

			tmpd[i]=*tmp; /* tmpd stores skills */
			tmp++;
			i++;
		}
		tmp++;
		i=0;
		while(*tmp!=')')
		{

			tmpe[i]=*tmp; /* tmpe stores salary */
			tmp++;
			i++;
		}

		EmpId= atoi(tmpa);
		Salary= atof(tmpe);
		insert(EmpId, tmpb, tmpc, tmpd, Salary);

	}

	else if(strcmp(substring(command, strlen("Update Employee set ")), "update employee set")==0)
	{
		tmp=command1;

		for(i=0; i<strlen("update employee set "); i++)
		{
			tmp++;
		}

		k=0;


		while(*tmp!=' ')
		{

			i=0;
			while(*tmp!='=')
			{

				tempa[k][0][i]=*tmp;
				tmp++;
				i++;
			}
			tmp++;
			i=0;
			while((*tmp!=',')||(*tmp!=';'))
			{

				tempa[k][1][i]=*tmp;
				tmp++;
				i++;
			}

			k++;

		}		/* k stores the number of fields entered by the user to update */

		tmp+=7; /* to reach after where */
		i=0;
		while(*tmp!='=')
		{

			tmp1[i]=*tmp; /* tmp1 saves the field based on which update is made */
			tmp++;
			i++;
		}
		tmp++;
		i=0;
		while(*tmp!='=')
		{

			tmp2[i]=*tmp; /* tmp2 saves the user input value*/
			tmp++;
			i++;
		}


		if(strcmp(tmp1, "empid")==0)
		{

			int id, flag=0;
			id= atoi(tmp2);
			for(i=0; i<num; i++)
			{
				if(employees[i].empId==id)
				{
					flag=1;
					update(k, tempa, i);

				}
			}
			if(flag==0)
			printf("\n No record.");

		}

		else if(strcmp(tmp1, "name")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].name),tmp2)==0)
				{
					flag=1;
					update(k, tempa, i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}
		else if(strcmp(tmp1, "dept name")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].deptName),tmp2)==0)
				{
					flag=1;
					update(k, tempa, i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}
		else if(strcmp(tmp1, "skills")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].skills),tmp2)==0)
				{
					flag=1;
					update(k, tempa, i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}

		else if(strcmp(tmp1, "salary")==0)
		{
			double Salary; int flag=0;
			Salary= atof(tmp2);
			for(i=0; i<num; i++)
			{
				if(employees[i].salary==Salary)
				{
					flag=1;
					update(k, tempa, i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}





	}

	else if(strcmp(substring(command, strlen("Delete from Employee where ")), "delete from employee where ")==0)
	{
		for(i=0; i<strlen("delete from employee where "); i++)
		{
			tmp++;
		}
		i=0;
		while(*tmp!='=')
		{

			tmp1[i]=*tmp; /* tmp1 stores the field */
			tmp++;
			i++;
		}
		tmp++;
		i=0;
		while(*tmp!=';')
		{

			tmp2[i]=*tmp; /* tmp2 stores user input value */
			tmp++;
			i++;
		}
		if(strcmp(tmp1, "empid")==0)
		{
			int id, flag=0;
			id= atoi(tmp2);
			for(i=0; i<num; i++)
			{
				if(employees[i].empId==id)
				{
					flag=1;
					deleteRecord(i);

				}
			}
			if(flag==0)
			printf("\n No record.");

		}

		else if(strcmp(tmp1, "name")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].name),tmp2)==0)
				{
					flag=1;
					deleteRecord(i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}
		else if(strcmp(tmp1, "dept name")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].deptName),tmp2)==0)
				{
					flag=1;
					deleteRecord(i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}
		else if(strcmp(tmp1, "skills")==0)
		{
			int flag=0;
			for(i=0; i<num; i++)
			{
				if(strcmp(lowercase(employees[i].skills),tmp2)==0)
				{
					flag=1;
					deleteRecord(i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}

		else if(strcmp(tmp1, "salary")==0)
		{
			double Salary; int flag=0;
			Salary= atof(tmp2);
			for(i=0; i<num; i++)
			{
				if(employees[i].salary==Salary)
				{
					flag=1;
					deleteRecord(i);
				}
			}
			if(flag==0)
			printf("\n No record.");
		}
		commandInterpretor();
		
	}
	else printf("\n Wrong Command! Please follow syntax!");
	commandInterpretor();
}

void printRecord(int n)
{
	printf("%d %s %s %s %lf\n", employees[n].empId, employees[n].name, employees[n].deptName, employees[n].skills, employees[n].salary);
}

void insert(int EmpId, char Name[20], char DeptName[20], char Skills[20], double Salary)
{
	int flag= checkId(EmpId);
	
	if(flag==0)
	{
		employees[num].empId=EmpId;
		strcpy(employees[num].name,Name);
		strcpy(employees[num].deptName,DeptName);
		strcpy(employees[num].skills, Skills);
		employees[num].salary=Salary;
		num++;
		updateFile();
		commandInterpretor();
	}
	
	else if(flag==1)
	{
		printf("\n ID not unique!");
	}
	
	
}

int checkId(int id)
{
	int i; int flag=0;
	for (i=0; i<num; i++)
	{
		if (employees[i].empId==id)
		flag = 1;
	}
	return (flag);
}

void deleteRecord(int i)
{
	int j;
	for(j=i; j<num-1; j++)
	{
		employees[j].empId=employees[j+1].empId;
		strcpy(employees[j].name, employees[j+1].name);
		strcpy(employees[j].deptName, employees[j+1].deptName);
		strcpy(employees[j].skills, employees[j+1].skills);
		employees[j].salary=employees[j+1].salary;
		num--;
		
	}
}

void updateFile()
{
	FILE *ifp= fopen("Employee.txt", "w");

	if (ifp == NULL) {
		printf("Couldn't open file!");
		exit(1);
	}

	fprintf(ifp, "%d \n", num);
	
	
	
	
	for(i=0; i<num; i++)
	{
		fprintf(ifp, "%d %s %s %s %lf \n", &employees[i].empId, &employees[i].name, &employees[i].deptName, &employees[i].skills, &employees[i].salary);
	}
	fclose(ifp);

	
}

void update(int k, char tmpa[5][2][30], int i)
{
	/* k stores the number of fields entered by the user to update */
	/* i stores the place in the structure array where to update */
	
	int j;
	for(j=0; j<k; j++)
	{
		if(strcmp(tmpa[j][0], "EmpId")==0)
		{
			employees[i].empId= atoi(tmpa[j][1]);
		}
		
		else if(strcmp(tmpa[j][0], "Name")==0)
		{
			strcpy(employees[i].name,tmpa[j][1]);
		}
		
		else if(strcmp(tmpa[j][0], "DeptName")==0)
		{
			strcpy(employees[i].deptName,tmpa[j][1]);
		}
		else if(strcmp(tmpa[j][0], "Skills")==0)
		{
			strcpy(employees[i].skills,tmpa[j][1]);
		}
		else if(strcmp(tmpa[j][0], "Salary")==0)
		{
			employees[i].salary= atof(tmpa[j][1]);
		}
		
	}
	
}

int main()
{
	commandInterpretor();
	return(0);
	
}