git checkout master
git status
git checkout -b GitWork
echo "<message>Hello from GitWork</message>" > hello.xml
echo "<message>Updated in GitWork branch</message>" > hello.xml
git status
git add hello.xml
git commit -m "Added hello.xml in GitWork"

git checkout master
echo "<message>Hello from Master</message>" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in master"

git log --oneline --graph --decorate --all
git diff master GitWork
git merge GitWork

# Resolve conflict
git add hello.xml
git commit -m "Resolved merge conflict"

echo "*.bak" > .gitignore
echo "*.orig" >> .gitignore
git add .gitignore
git commit -m "Added backup files to .gitignore"

git branch
git branch -d GitWork
git log --oneline --graph --decorate