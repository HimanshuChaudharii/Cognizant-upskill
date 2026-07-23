command used:

git branch GitNewBranch
git branch -a
git checkout GitNewBranch
echo "This file is created in GitNewBranch" > branch.txt
git add branch.txt
git commit -m "Added branch.txt in GitNewBranch"
git status
git checkout main        # or master
git diff main GitNewBranch
git config --global diff.tool p4merge
git config --global merge.tool p4merge
git difftool main GitNewBranch
git merge GitNewBranch
git log --oneline --graph --decorate
git branch -d GitNewBranch
git status