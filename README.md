
🎇 HRMS SYSTEM 🎇
Requirements 🎆
🎑 Req 1: Job seekers must be able to register in the system.
Acceptance Criteria:

During registration, the user is prompted for name, surname, national identification number, birth year, email, password, and password confirmation.
All fields are mandatory. The user is informed accordingly.
Registration is performed by validating against the Mernis system.
If validation fails, the user is informed.
Registration is not allowed if the email or national identification number is already registered. The user is informed.
Email verification is required for registration to be completed.

🏞 Req 2: Employers must be able to register in the system.
Acceptance Criteria:

During registration, the user is prompted for company name, website, email matching the website domain, phone number, password, and password confirmation. The purpose here is to prevent non-companies from joining the system.
All fields are mandatory. The user is informed accordingly.
Company registrations are validated in two ways. Email verification is required for registration to be completed. Approval from HRMS personnel (ours :)) is also necessary.
Registration is not allowed if the email is already registered. The user is informed.

🌅 Req 3: General job position names can be added to the system. For example, Software Developer, Software Architect.
Acceptance Criteria:

These positions must not be duplicated. The user is alerted.

🌄 Req 4: Employers can be listed. (Only the full list)
🌠 Req 5: Job seekers can be listed. (Only the full list)
Req 6: Job positions can be listed. (Only the full list)

🛤 Req 7: Employers can add job listings to the system.
In the job listing form:
A general job position can be selected from a dropdown list. (For example, Java Developer) (Mandatory)
A job description can be entered. (For example, proficiency in languages such as JAVA, C# for our company....) (Mandatory)
City information can be selected from a dropdown list. (Mandatory)
A min-max salary range can be entered. (Optional)
The number of open positions can be entered. (Mandatory)
The deadline for application can be entered.

🛣 Req 8: All active job listings in the system can be listed.
The list should be presented in table format.
The list should include company name, general job position name, number of open positions, publication date, and application deadline.

⛲️ Req 9: All active job listings in the system can be listed by date.
The list should be presented in table format.
The list should include company name, general job position name, number of open positions, publication date, and application deadline.

⛱ Req 10: All active job listings belonging to a company can be listed.
The list should be presented in table format.
The list should include company name, general job position name, number of open positions, publication date, and application deadline.

🏝 Req 11: Employers can close a job listing in the system. (Inactive listing)
🏜 Req 12: Candidates can enter their CV information into the system.
Candidates can add the schools they attended to the system. (School name, department)
They can enter the years they attended these schools into the system.
If they have not graduated, the graduation year field can be left blank.
The schools attended by candidates can be sorted in reverse order based on graduation year. If not graduated, this school should still be displayed at the top and marked as "ongoing".
Candidates can enter their work experiences. (Workplace name, position)
They can enter the years they worked at these positions into the system.
If they are still working, the year of leaving the job can be left blank.
Candidates' experiences can be sorted by year in reverse order. If still working, this experience should still be displayed at the top and marked as "ongoing".
Candidates can enter the foreign languages they know into the system. (Language, Level -> 1-5)
Candidates can upload a photo into the system. The candidate's photo will be stored in the system using https://cloudinary.com/pricing. (External service integration) Please use the free account.
Candidates can enter their GitHub addresses into the system.
Candidates can enter their LinkedIn addresses into the system.
Candidates can enter the programming languages or technologies they know into the system. (Programming/Technology name) For example; React
Candidates can add a cover letter to the system. (For example: I love working....)

🏕 Req 13: All CV information belonging to a candidate can be viewed.
All text should be in English, just like provided.
