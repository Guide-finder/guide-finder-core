
# Описание проекта

Здесь будет храниться информация о классах, таблицах и их связи.
Инструкция по сборке jar и uml диаграммы

# Model description

    # category package
        Class Category
            -logn id;
            -string name;
            -string description
            -Set<Guide> (many to many relationship)
        
    # comment package
        Class Commentary
             -long authiorId;
             -long recipientId;
             -string message;
             
     # contact package
        Class Social Contact
            -string link
            -social contact type
            
        Enum SocialContactType
        
    # location package
        Class AbstractLocation
            -long id
            - string name
        
        Class City
            -Region region (many to one)
            
        Class Country
            -List Region regions
            
        Class Region
            -Country country (many to one)
            -List Cities cities (one to many)
            
    # user package
        Class AbstractUser
            -long id
            -string firstName
            -string lastName
            -string password
            -string phone
            -string email
            -Sex sex
            -int age
            -Set <Role> roles (one to many)
            
        Class Guide
            -City city
            -Set<Language> languages (one to many)
            -Set<Category> categories (one to many)
            -Set<SocialContacts> socialContacts (many to many)
            
        Enum Language
        
        Enum LanguageLevel
        
        Class Role
            -long id
            -string name
            
        Enum Sex
        
        Class Stuff
            -double salary
            
            
     