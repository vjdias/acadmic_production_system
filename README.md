# acadmic_production_system
This project consists of an academic productivity management system in which production management can be done research laboratory, including information on research projects and collaborators.

  The program was written using eclipse 2020-09.
  The program's initial screen consists of:

  0:Gerenciar dados  
  1:Atualizar projetos  
  2:Imprimir relatorio de produção academica  
  3:Sair  

  Option 0 gives the user the ability to add data to the program's model class sets;  
  Option 1 makes it possible to update project data already added to the data;  
  Option 2 allows the printing of a report that summarizes some of the project data;  
  Option 3 terminates the program.  
  
  Note to add relationships between models, you must first add the model to be related (0: Manage data) so that you can get your reference and add it to another model.
  
  Example 
```  
  
Digite os valores correspondentes aos seguintes campos:

Title:
>Teste

FinancingCompany:
>Teste

FinancingAmount:
>Teste

Description:
>Teste

StartYear:
>2020

ConclusionYear:
>2021

Status:
>in preparation

CollaboratorsFk
Digite o Id(s) que deseja associar a este modelo.
 _____________________________________________________________________________________________________________________________________________
|Name__________|Id________|Email__________|AcademicDegree____________|HistoryProjectParticipationFk________|HistoryProjectProductionFk________|
|Maria         |0         |ma@com         |Professor                 |[0]                                  |[]                                |
|João          |1         |jo@com         |Professor                 |[1]                                  |[]                                |
|Camila        |2         |ma@com         |University student        |[0]                                  |[]                                |
|Valdir        |3         |va@com         |University student        |[]                                   |[]                                |
|José__________|4_________|jos@com________|University student________|[1]__________________________________|[]________________________________|

> 0 2
```

  Diagrams   
  Model 
![Model](https://github.com/vjdias/acadmic_production_system/blob/master/diagram/model.PNG)
  Controller
![Model](https://github.com/vjdias/acadmic_production_system/blob/master/diagram/controller.PNG)
  View and Utils
![Model](https://github.com/vjdias/acadmic_production_system/blob/master/diagram/view_util.PNG)
