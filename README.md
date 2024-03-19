# LAB-PM-11-2024

## Note
- Make sure your folder name is `Praktikum-n` | Ex: `Praktikum-1`
- Your Folder Content:
  1. .apk file
  2. Your Android Studio project folder
##
### Step 1: Fork the Repository
1. Log in to GitHub and navigate to your repository.
2. Click on the "Fork" button at the top-right corner of this repository page. This will create a copy of the repository under each your GitHub account.

### Step 2: Clone the Forked Repository
1. Open Android Studio.
2. Select "Get from Version Control System" from the welcome screen or go to `VCS > Git > Clone` //or// go to your main menu(Alt + \), then select `VCS > Enable VCS > Select Git > Ok`, after that go to your main menu again and select `Git > Clone`.
3. Copy the URL of the forked repository from your GitHub account.
4. Paste the URL into the URL field in Android Studio.
5. Click "Clone" to download the forked repository to their local machine.

### Step 3: Configure Remote Repository
1. In Android Studio, go to `VCS > Git > Manage Remotes...`.
2. Click on the "+" sign to add a new remote repository.
3. Enter a name for the remote (e.g., `origin`) and paste the URL of the original repository (your repository) as the URL.
4. Click "OK" to add the remote repository.

### Step 4: Make Changes to the Project
1. Open the project in Android Studio.
2. Make necessary changes or modifications to the project.

### Step 5: Commit and Push Changes
1. Go to `VCS > Commit` to open the commit dialog.
2. Select the files you want to commit by checking the boxes next to their names.
3. Enter a commit message describing the changes made.
4. Click on the "Commit" button to commit the changes.
5. After commit, create new branch by `Ctrl + Alt + N` then enter your NIM as the branch name.
6. After committing changes, go to `VCS > Git > Push` to push the changes to the forked repository on GitHub.
7. In the Push dialog, select your NIM as the branch click "Push" to upload your changes to GitHub.

### Step 6: Create a Pull Request
1. After pushing changes to the forked repository, navigate to the forked repository on GitHub.
2. Click on the "New pull request" button.
3. GitHub will automatically detect the changes you made and provide a comparison between the original repository and your fork.
4. Review the changes and click on the "Create pull request" button.
5. Provide a title and description for your pull request, then click "Create pull request" again to submit it.

### Step 7: Wait for Approval
1. Once the pull request is created, the owner of the original repository (you) will receive a notification.
